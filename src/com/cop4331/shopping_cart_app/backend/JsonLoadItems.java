package com.cop4331.shopping_cart_app.backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonLoadItems implements ILoad<Item> {

	@Override
	public ArrayList<Item> load(String fileName) {
		
		ArrayList<Item> li=new ArrayList<Item>();
		try {
			Object obj=new JSONParser().parse(new FileReader(fileName));
			JSONArray jo=(JSONArray) obj;
			JSONObject ja=new JSONObject();
			ja=(JSONObject) jo.get(0);
			/*
			System.out.println(ja.get("name"));
			System.out.println(ja.get("item_description"));
			System.out.println(ja.get("quantity"));
			System.out.println(ja.get("price"));
			System.out.println(ja.get("sellerID"));
			*/
			
			//name, description, quantity, price
			
			for(int i=0; i<jo.size(); i++) {
				ja=(JSONObject) jo.get(i);
				String name=(String) ja.get("name");
				String item_description=(String) ja.get("item_description");
				int quantity= Integer.parseInt((String) ja.get("quantity"));
				double price=Double.parseDouble((String) ja.get("price"));
				int sellerID=Integer.parseInt((String) ja.get("sellerID"));
				
				li.add(new Item(name, item_description, sellerID, quantity, price));
				System.out.println("Loading Item :"+li.get(i).print());
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
