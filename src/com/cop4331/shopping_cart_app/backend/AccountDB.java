package com.cop4331.shopping_cart_app.backend;

import java.io.File;
import java.util.*;

/**
 *
 * @author Justin Ament
 */
public class AccountDB {
    
    private static ArrayList<Account> accounts;
    private static String fileName="Accounts.json";
    
    public static void init() {
    	
    	if(ifFileExists()) {
			load();
		}else {
			createInitialAccounts();
			save();
		}
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
    
    public Account getAccount(String username, String password) {
    	return null;
    }
    
    public static void createInitialAccounts() {
    	accounts=new ArrayList<Account>();
    	accounts.add(new Customer("michael", "1234"));
    	accounts.add(new Seller("justin", "1234"));
    	
    }
    
    public static void save() {
    	ISave<Account> accountSaver=new JsonSaveAccounts();
    	accountSaver.save(fileName, accounts);
    }
    
    public static void load() {
    	ILoad<Account> accountLoader = new JsonLoadAccounts();
    	accounts = accountLoader.load(fileName);
    }
    
    private static boolean ifFileExists() {
		return new File(fileName).exists();
	}
}
