
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
    	Item a=new Item("Banana", "Fresh banana", 0, 14);
    	item.add(a);
    	a=new Item("Milk", "Whole milk", 1, 12);
    	item.add(a);
    	a=new Item("Item", "test item", 2, 1);
    }
    
    //updates the quantity of a certain item
    public static void UpdateItem(Item a, int new_quantity) {
    	for(int i=0; i<item.size(); i++) {
    		if(a==item.get(i)) {
    			if(new_quantity==0)
    				item.remove(i);
    			else
    				item.get(i).quantity=new_quantity;
    		}
    	}
    }
    
    //gets all items from a seller
    public static List<Item> GetItemBySeller(int id) {
    	List<Item> seller_items=new ArrayList<Item>();
    	for(int i=0; i<item.size(); i++) {
    		if(item.get(i).getSellerID()==id) seller_items.add(item.get(i));
    	}
    	return seller_items;
    }
    
    //returns full item list
    public static List<Item> getFullInventory() {
    	return item;
    }
    
    public static Item getItem(int itemID) {
    	return item.get(itemID);
    }
    
    public static void AddItem(Item a) {
    	item.add(a);
    }
    
}
