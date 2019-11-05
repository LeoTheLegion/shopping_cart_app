
package com.cop4331.shopping_cart_app.core;
/**
 *
 * @author Justin Ament
 */

public class Item {
    String name;
    String info;
    int quantity;
    String seller; 
    
    public Item(String name, String info, String seller, int quantity) {
        this.name=name;
        this.info=info;
        this.seller=seller;
        this.quantity=quantity;
    }
    
    public Item() {
    	this.name="";
    	this.info="";
    	this.seller="";
    	this.quantity=0;
    }
}
