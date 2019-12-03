
package com.cop4331.shopping_cart_app.databases;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.cop4331.shopping_cart_app.filemanager.ILoad;
import com.cop4331.shopping_cart_app.filemanager.ISave;
import com.cop4331.shopping_cart_app.graphics.windowmanager.WindowManager;
import com.cop4331.shopping_cart_app.item.Item;
import com.cop4331.shopping_cart_app.item.JsonLoadItems;
import com.cop4331.shopping_cart_app.item.JsonSaveItems;



/**
 *
 * @author Justin Ament , Michael Mena
 */

public class ItemDB{

	private ArrayList<Item> items;
	private final String fileName = "Items.json";
	private static ItemDB INSTANCE;
	
	/**
	 * 
	 */
	public ItemDB() {
		if(ifFileExists()) {
			load();
		}else {
			buildInitialDB();
			save();
		}
	}
	
	/**
	 * @returns INSTANCE
	 */
	public static ItemDB getInstance() {
		if(INSTANCE == null) {
			synchronized(WindowManager.class) {
				if(INSTANCE == null)
					INSTANCE = new ItemDB();
			}
		}
		return INSTANCE;
	}
	
	/**
	 * Forces creates INSTANCE
	 */
	public static void init() {
		getInstance();
	}

	/**
	 * build prefab DB
	 */
	private void buildInitialDB() {
		items = new ArrayList<Item>();
		
		addItem(new Item("Justins Item", "Justins Item to sell", 1,500,15,8));
		addItem(new Item("Justins Item2", "Justins Item to sell", 1,500,15,8));
		addItem(new Item("Justins Item3", "Justins Item to sell", 1,500,15,8));
		addItem(new Item("Justins Item4", "Justins Item to sell", 1,500,15,8));
	}
	
    /**
     * @param itemID
     * @param new_quantity
     * updates the quantity of a certain item
     */
    public void setQuantity(int itemID, int new_quantity) {
    	items.get(itemID).setQuantity(new_quantity);
    }
    
    /**
     * @param id
     * @returns items from a seller
     */
    public List<Item> getItemBySeller(int id) {
    	List<Item> seller_items=new ArrayList<Item>();
    	for(int i=0; i<items.size(); i++) {
    		if(items.get(i).getSellerID()==id) seller_items.add(items.get(i));
    	}
    	return seller_items;
    }
    /**
     * @returns item list
     */
    public List<Item> getFullInventory() {
    	return items;
    }
    
    /**
     * @param itemID
     * @returns item
     */
    public Item getItem(int itemID) {
    	return items.get(itemID);
    }
    
    /**
     * @param a
     * @return itemID
     */
    public int getItemID(Item a) {
    	int value=-1;
    	for(int i=0; i<items.size(); i++) {
    		if(a==items.get(i)) value=i;
    	}
    	return value; 
    }
    
    /**
     * @param a
     * adds item to DB
     */
    public void addItem(Item a) {
    	items.add(a);
    	//save(); <--- too slow
    }
	
	
	/**
	 * @returns true if file exists
	 */
	private boolean ifFileExists() {
		return new File(fileName).exists();
	}
	 
	
	/**
	 * loads DB
	 */
	void load() {
		System.out.println("LOADING ITEMS");
		ILoad<Item> itemloader = new JsonLoadItems();
		
		items = itemloader.load(fileName);
	}
	
	/**
	 * save DB
	 */
	public void save() {
		System.out.println("SAVING ITEMS");
		ISave<Item> itemSaver = new JsonSaveItems();
		itemSaver.save(fileName,items);
	}
}

