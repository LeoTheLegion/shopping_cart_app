
package com.cop4331.shopping_cart_app.core;

import java.util.*;

/**
 *
 * @author Justin Ament
 */

public class ItemDB {

	List<Item> item=new ArrayList<Item>();
	
    public void BuildDB() {
    	
    }
    
    public void Populate() { 
    	
    }
    
    public void UpdateItem(Item a) {
    	
    }
    
    public Item GetItemBySeller(String s) {
    	Item a=new Item();
    	for(int i=0; i<item.size(); i++) {
    		if(item.get(i).seller==s) a=item.get(i);
    	}
    	return a;
    }
    
    public void AddItem(Item a) {
    	item.add(a);
    }
    
}
