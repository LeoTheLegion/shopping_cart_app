package com.cop4331.shopping_cart_app.item;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.*;

import com.cop4331.shopping_cart_app.filemanager.ISave;

public class JsonSaveItems implements ISave<Item> {

	/* (non-Javadoc)
	 * @see com.cop4331.shopping_cart_app.filemanager.ISave#save(java.lang.String, java.util.ArrayList)
	 * saves items via JSON
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public void save(String fileName, ArrayList<Item> items) {
		// TODO Auto-generated method stub
		JSONArray item_list=new JSONArray();
		
		for(int i=0; i<items.size(); i++) {
			//System.out.println("saving: "+ items.get(i).print());
			JSONObject item=new JSONObject();
			item.put("name", items.get(i).getName());
			item.put("item_description", items.get(i).getDescription());
			item.put("sellerID", Integer.toString(items.get(i).getSellerID()));
			item.put("quantity", Integer.toString(items.get(i).getQuantity()));
			item.put("price", Double.parseDouble(items.get(i).getPrice()));
			item.put("invPrice", Double.parseDouble(items.get(i).getInvPrice()));
			System.out.println("Saving item: " +item.toString());
			item_list.add(item);
		}

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");
		}
		writer.write(item_list.toString());
		writer.flush();
		writer.close();
	}

}
