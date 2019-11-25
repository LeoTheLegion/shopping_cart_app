package com.cop4331.shopping_cart_app.backend;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSaveItems implements ISave<Item> {

	@Override
	public void save(String fileName, ArrayList<Item> items) {
		// TODO Auto-generated method stub
		JSONArray ja=new JSONArray();
		
		for(int i=0; i<items.size(); i++) {
			//System.out.println("saving: "+ items.get(i).print());
			JSONObject jo=new JSONObject();
			jo.put("name", items.get(i).getName());
			jo.put("item_description", items.get(i).getDescription());
			jo.put("sellerID", Integer.toString(items.get(i).getSellerID()));
			jo.put("quantity", Integer.toString(items.get(i).getQuantity()));
			jo.put("price", Double.toString(items.get(i).getPrice()));
			System.out.println("Saving item: " +jo.toString());
			ja.add(jo);
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");
		}
		pw.write(ja.toString());
		pw.flush();
		pw.close();
	}

}
