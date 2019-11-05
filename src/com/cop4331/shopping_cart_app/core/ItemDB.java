
package com.cop4331.shopping_cart_app.core;

import java.util.*;

/**
 *
 * @author Justin Ament
 */

public class ItemDB {

	static List<Item> item=new ArrayList<Item>();
	
	/*
    public static void BuildDB() {
    	
    }
    */
	
    public static void Populate() { 
    	//populates the item ArrayList
    	//sample items
    	
    	//Item(name, info, seller, quantity)
    	Item a=new Item("Banana", "Fresh banana", "John Wick", 14);
    	item.add(a);
    	a=new Item("Milk", "Whole milk", "Bob", 12);
    	item.add(a);
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
    
    public static Item GetItemBySeller(String s) {
    	Item a=new Item();
    	for(int i=0; i<item.size(); i++) {
    		if(item.get(i).seller==s) a=item.get(i);
    	}
    	return a;
    }
    
    public static void AddItem(Item a) {
    	item.add(a);
    }
    
}
