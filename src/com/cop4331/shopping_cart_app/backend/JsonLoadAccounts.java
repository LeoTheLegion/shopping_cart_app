package com.cop4331.shopping_cart_app.backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonLoadAccounts implements ILoad<Account> {

	@Override
	public ArrayList<Account> load(String fileName) {
		// TODO Auto-generated method stub
		ArrayList<Account> li=new ArrayList<Account>();
		try {
			Object obj=new JSONParser().parse(new FileReader(fileName));
			JSONArray jo=(JSONArray) obj;
			JSONObject ja=new JSONObject();
			ja=(JSONObject) jo.get(0);
			
			//name, description, quantity, price
			
			for(int i=0; i<jo.size(); i++) {
				ja=(JSONObject) jo.get(i);
				String username=(String) ja.get("username");
				String password=(String) ja.get("password");
				String cart=(String) ja.get("cart");
				
				double price=Double.parseDouble(ja.get("price").toString());
				int sellerID=Integer.parseInt((String) ja.get("sellerID"));
				
				String acc_type=(String) ja.get("acc_type");
				if(acc_type=="0")
					li.add(new Customer(username, password,cart));
				else 
					li.add(new Seller(username, password));
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;

	}
}

