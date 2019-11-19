
package com.cop4331.shopping_cart_app.backend;



import java.util.*;
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.JSONArray;
import org.json.*;


/**
 *
 * @author Justin Ament
 */

public class ItemDB {

	static List<Item> item;
	
	public static void init() { 
		item =new ArrayList<Item>();
		toFile();
		//Populate();
	}
	
	public static void toFile() {
		JSONObject jo=new JSONObject();

		//name, description, quantity, price
		try {
			jo.put("name", "Banana");
			jo.put("item_description", "Fresh Banana");
			jo.put("quantity", 14);
			jo.put("price", 0.70);
			
			PrintWriter pw=new PrintWriter("itemdb.json");
			pw.write(jo.toString());
			pw.flush();
			//pw.close();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		catch(FileNotFoundException e) {
			System.out.println("No file found");
		}
	}

    public static void Populate() { 
    	
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
