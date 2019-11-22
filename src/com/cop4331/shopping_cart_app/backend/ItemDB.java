
package com.cop4331.shopping_cart_app.backend;



import java.util.*;
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.JSONArray;
import org.json.*;

//Create interface adapter called IRead that reads from a file


/**
 *
 * @author Justin Ament
 */

public class ItemDB extends JSon {

	private static ArrayList<Item> items;
	
	public static void init() { 
		ItemDB a=new ItemDB();
		//Populate();
	}
	
	public ItemDB() {
		items =new ArrayList<Item>();
		//toFile();
		items=this.load("itemdb.json");
		for(int i=0; i<items.size();i++) {
			System.out.println("Constructor " + items.get(i).print());
			
		}
		//Tester();
	}
	
	public ItemDB(ArrayList<Item> item) {
		this.items=item;
		this.save("itemdb.json", items);
	}
	
    public static void Tester() { 
    	System.out.println("Making first item: ");
		Item a=new Item("Tester1", "testing thing1", 11, 21, 31.0);
		addItem(a);
    }
    
    //updates the quantity of a certain item
    public static void setQuantity(int itemID, int new_quantity) {
    	items.get(itemID).setQuantity(new_quantity);
    }
    
    //gets all items from a seller
    public static List<Item> getItemBySeller(int id) {
    	List<Item> seller_items=new ArrayList<Item>();
    	for(int i=0; i<items.size(); i++) {
    		if(items.get(i).getSellerID()==id) seller_items.add(items.get(i));
    	}
    	return seller_items;
    }
    
    //returns full item list, eventually change to sample list of items
    public static List<Item> getFullInventory() {
    	return items;
    }
    
    public static Item getItem(int itemID) {
    	return items.get(itemID);
    }
    
    public static int getItemID(Item a) {
    	int value=-1;
    	for(int i=0; i<items.size(); i++) {
    		if(a==items.get(i)) value=i;
    	}
    	return value; 
    }
    
    public static void addItem(Item a) {
    	items.add(a);
    	ItemDB x =new ItemDB(items);
    }

    public void save() {
    	this.save();
    }
}


//Need to add a way to save the file with the new contents after the addItem function
