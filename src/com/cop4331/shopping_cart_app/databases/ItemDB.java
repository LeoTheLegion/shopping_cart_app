
package com.cop4331.shopping_cart_app.databases;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cop4331.shopping_cart_app.filemanager.ILoad;
import com.cop4331.shopping_cart_app.filemanager.ISave;
import com.cop4331.shopping_cart_app.item.Item;
import com.cop4331.shopping_cart_app.item.JsonLoadItems;
import com.cop4331.shopping_cart_app.item.JsonSaveItems;



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
			save();
		}
	}

	/**
	 * 
	 */
	private static void buildInitialDB() {
		items = new ArrayList<Item>();
		
		addItem(new Item("Justins Item", "Justins Item to sell", 1,0,15));
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
    	//save(); <--- too slow
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
	
	public static void save() {
		System.out.println("SAVING ITEMS");
		ISave<Item> itemSaver = new JsonSaveItems();
		itemSaver.save(fileName,items);
	}
}

