package com.cop4331.shopping_cart_app.backend;

import java.util.ArrayList;

public class Customer extends Account {
	
	private ArrayList<Item> cart;
	
	public Customer(String username, String password, String cart) {
		this.username = username;
		this.password = password;
		
	}

	public Customer(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
	}

}
