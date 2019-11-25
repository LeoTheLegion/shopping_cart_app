
package com.cop4331.shopping_cart_app.backend;
/**
 *
 * @author Justin Ament
 */

public class Item {
    private static String name="";
    private static String item_description="";
    static int quantity=0;
    private static int sellerID=-1; 
    private static double price=0;
    
    //name, description, quantity, price
    public Item(String name, String item_description, int sellerID, int quantity, double price) {
        this.name=name;
        this.item_description=item_description;
        this.sellerID=sellerID;
        this.quantity=quantity;
        this.price=price;
    }
    
    //Item doesn't exist
    public Item() {

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
    
    public double getPrice() { 
    	return price;
    }
    
    public void setQuantity(int q) {
    	this.quantity = q;
    }
    
    //used for testing purposes
    public String print() {
    	return name+" "+ item_description + " " + Integer.toString(quantity) + " " + Double.toString(price);
    }
}
