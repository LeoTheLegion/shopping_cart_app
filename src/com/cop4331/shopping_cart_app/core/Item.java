
package com.cop4331.shopping_cart_app.core;
/**
 *
 * @author Justin Ament
 */

public class Item {
    String name;
    String item_description;
    int quantity;
    int sellerID; 
    
    public Item(String name, String item_description, int sellerID, int quantity) {
        this.name=name;
        this.item_description=item_description;
        this.sellerID=sellerID;
        this.quantity=quantity;
    }
    
    public Item() {
    	this.name="";
    	this.item_description="";
    	this.sellerID=-1;
    	this.quantity=0;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return item_description;
    }
    
    public int getSellerID() {
        return sellerID;
    }
    
    public int getQuantity() {
        return quantity;
    }
}
