package com.cop4331.shopping_cart_app.backend;

import java.util.ArrayList;

public interface IReadFiles {

	public void save(String f, ArrayList<Item> a);
	public ArrayList<Item> load(String f);
}

//Account can have a list of items to represent the cart. this can be saved in the accounts JSON file and store 
//the cart items into an array.