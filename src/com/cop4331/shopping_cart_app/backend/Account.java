/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop4331.shopping_cart_app.backend;

/**
 *
 * @author Justin Ament
 */
public class Account {
    private  String username="";
    private  String password="";
    public  String acc_type="";
    
    public Account(String username, String password, String acc_type) {
    	this.username=username;
    	this.password=password;
    	this.acc_type=acc_type;
    }
    
    public Account() {
    	//account doesn't exist, no credentials
    }
    
    public String getAccType() {
    	return this.acc_type;
    }
    
    public String getUsername() {
    	return this.username;
    }
    
    public String getPassword() {
    	return this.password;
    }
}
//could use inheritance pattern
//could seperate seller and buyer by files