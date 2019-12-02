package com.cop4331.shopping_cart_app.backend;

import java.util.HashMap;


public class Customer extends Account {
	
	public HashMap<Integer,Integer> cart;
	
	public Customer(String username, String password, String cartStr) {
		this.username = username;
		this.password = password;
		this.cart = new HashMap<Integer,Integer>();
		
		if(!cartStr.isEmpty()) {
			String[] entry = cartStr.split(",");
			
			for (int i = 0; i < entry.length; i++) {
				String[] l = entry[i].split(":");
				
				int itemID = Integer.parseInt(l[0]);
				int qual = Integer.parseInt(l[1]);
				
				cart.put(itemID, qual);
				
			}
		}
		
		
	}
	
	public String cartToString() {
		String str = "";
		Object[] keyset = cart.keySet().toArray();
		for (int i = 0; i < keyset.length; i++) {
			int itemID = (int) keyset[i];
			int qual = cart.get(keyset[i]);
			
			str += itemID + ":" + qual;
			
			if(i < keyset.length - 1)
				str += ",";
			
		}
		
		return str;
	}

	public Customer(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
	}

}
