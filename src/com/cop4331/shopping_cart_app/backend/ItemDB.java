
package com.cop4331.shopping_cart_app.backend;



import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.PrintWriter;

import org.json.*;

import com.cop4331.shopping_cart_app.backend.Item;



/**
 *
 * @author Justin Ament , Michael Mena
 */

public class ItemDB{

	private static ArrayList<Item> items;
	private static final String fileName = "Items.json";
	
	
	public static void init() {
		if(ifFileExists()) {
			load();
		}else {
			buildInitialDB();
		}
	}

	/**
	 * 
	 */
	private static void buildInitialDB() {
		items = new ArrayList<Item>();
		
		addItem(new Item("Testing1", "Testing1", 1,1,1));
		addItem(new Item("Testing2", "Testing2", 2,2,2));
		
		addItem(new Item("Banana", "Fresh banana", 0, 14, 0.70f));
		addItem(new Item("Milk", "Whole milk", 1, 12, 2.40f));
		addItem(new Item("Item", "test item", 2, 1, 1.0f));
	}

	
	 //updates the quantity of a certain item
    public static void setQuantity(int itemID, int new_quantity) {
    	items.get(itemID).quantity=new_quantity;
    }
    
    //gets all items from a seller
    public static List<Item> GetItemBySeller(int id) {
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
    	save();
    }
	
	
	/**
	 * @return
	 */
	private static boolean ifFileExists() {
		return new File(fileName).exists();
	}
	 
	
	static void load() {
		System.out.println("LOADING ITEMS");
		ILoad<Item> itemloader = new JsonLoadItems();
		
		items = itemloader.load(fileName);
	}
	
	static void save() {
		System.out.println("SAVING ITEMS");
		ISave<Item> itemSaver = new JsonSaveItems();
		itemSaver.save(fileName,items);
	}
}

