package com.cop4331.shopping_cart_app.account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.*;

import com.cop4331.shopping_cart_app.filemanager.ILoad;

public class JsonLoadAccounts implements ILoad<Account> {

	@SuppressWarnings("deprecation")
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
				
				String acc_type=(String) ja.get("acc_type");
				if(acc_type.equals("0")) {
					li.add(new Customer(username, password,cart));
					System.out.println("Loading Customer :" + username);
				}
				else {
					double profit=Double.parseDouble(ja.get("profit").toString());
					double cost=Double.parseDouble(ja.get("cost").toString());
					li.add(new Seller(username, password, profit, cost));
					System.out.println("Loading Seller :" + username);
				}
					
				
				
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

