package com.cop4331.shopping_cart_app.backend;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import com.cop4331.shopping_cart_app.core.Session;


public class Customer extends Account {
	
	private HashMap<Integer,Integer> cart;
	
	public Customer(String username, String password, String cartStr) {
		this.username = username;
		this.password = password;
		this.cart = new HashMap<Integer,Integer>();
		
		String[] entry = cartStr.split(",");
		
		for (int i = 0; i < entry.length; i++) {
			String[] l = entry[i].split(":");
			
			int itemID = Integer.parseInt(l[0]);
			int qual = Integer.parseInt(l[1]);
			
			cart.put(itemID, qual);
			
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
