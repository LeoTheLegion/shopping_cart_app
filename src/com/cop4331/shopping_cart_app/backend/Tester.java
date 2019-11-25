package com.cop4331.shopping_cart_app.backend;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ItemDB.init();
				
		ItemDB.save();
		
		//System.out.println(ItemDB.getFullInventory());
		;
		//ItemDB.addItem(new Item("Testing2", "Testing2", 2,2,2));
	}

}
