package com.cop4331.shopping_cart_app.backend;

import java.util.*;

/**
 *
 * @author Justin Ament
 */
public class AccountDB {
    
    private static List<Account> accounts=new ArrayList<Account>();
    
    public AccountDB() {
    	//will have to load/create the file for the database
    }
    
    public static void init() {
    	AccountDB db=new AccountDB();
    }
    
    public static boolean verify(String username, String password) {
    	return true;
    }
    
    protected static Account getAccByUsername(String username) {
    	
    	for(int i=0; i<accounts.size(); i++) {
    		if(accounts.get(i).getUsername()==username) {
    			return accounts.get(i);
    		}
    	}
    	return new Account();
    }
}
