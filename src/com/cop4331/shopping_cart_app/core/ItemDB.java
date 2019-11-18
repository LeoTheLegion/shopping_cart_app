
package com.cop4331.shopping_cart_app.core;


import java.util.*;

/**
 *
 * @author Justin Ament
 */

public class ItemDB {

	static List<Item> item;
	
	public static void init() { 
		item =new ArrayList<Item>();
		Populate();
	}
	
    public static void Populate() { 
    	//populates the item ArrayList
    	//sample items
    	
    	//Item(name, item_description, seller, quantity)
    	Item a=new Item("Banana", "Fresh banana", 0, 14, 0.70f);
    	item.add(a);
    	a=new Item("Milk", "Whole milk", 1, 12, 2.40f);
    	item.add(a);
    	a=new Item("Item", "test item", 2, 1, 1.0f);
    }
    
    //updates the quantity of a certain item
    public static void UpdateItem(int itemID, int new_quantity) {
    	item.get(itemID).quantity=new_quantity;
    }
    
    //gets all items from a seller
    public static List<Item> GetItemBySeller(int id) {
    	List<Item> seller_items=new ArrayList<Item>();
    	for(int i=0; i<item.size(); i++) {
    		if(item.get(i).getSellerID()==id) seller_items.add(item.get(i));
    	}
    	return seller_items;
    }
    
    //returns full item list, eventually change to sample list of items
    public static List<Item> getFullInventory() {
    	return item;
    }
    
    public static Item getItem(int itemID) {
    	return item.get(itemID);
    }
    
    public static int getItemID(Item a) {
    	int value=-1;
    	for(int i=0; i<item.size(); i++) {
    		if(a==item.get(i)) value=i;
    	}
    	return value; 
    }
    
    public static void AddItem(Item a) {
    	item.add(a);
    }
    
}
