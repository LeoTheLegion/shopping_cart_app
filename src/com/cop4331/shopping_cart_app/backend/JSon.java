package com.cop4331.shopping_cart_app.backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;



@SuppressWarnings("deprecation")
public class JSon implements IReadFiles {

	
	//Saves new Item a to the JSon file
	@Override
	public void save(String f, ArrayList<Item> a) {
		// TODO Auto-generated method stub
		JSONArray ja=new JSONArray();
		int count=0;
		for(int i=0; i<a.size(); i++) {
			System.out.println("save "+ a.get(i).print());
			JSONObject jo=new JSONObject();
			jo.put("name", a.get(i).getName());
			jo.put("item_description", a.get(i).getDescription());
			jo.put("sellerID", Integer.toString(a.get(i).getSellerID()));
			jo.put("quantity", Integer.toString(a.get(i).getQuantity()));
			jo.put("price", Double.toString(a.get(i).getPrice()));
			//System.out.println("Printing new item: " + count + jo.toString());
			ja.add(jo);
			count++;
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter("itemdb.json");
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");
		}
		pw.write(ja.toString());
		pw.flush();
		pw.close();
	}

	@Override
	public ArrayList<Item> load(String f) {
		// TODO Auto-generated method stub
		ArrayList<Item> li=new ArrayList<Item>();
		try {
			Object obj=new JSONParser().parse(new FileReader(f));
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
				System.out.println(li.get(i).print());
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

//Need to make a seperate method for the accountDB to read/write from file
