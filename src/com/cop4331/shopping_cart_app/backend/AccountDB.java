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
    	accounts.add(new Account("michael", "1234", "customer"));
    	accounts.add(new Account("justin", "1234", "seller"));
    	save();
    }
    
    public static void save() {
    	ISave<Account> accountSaver=new JsonSaveAccounts();
    	accountSaver.save(fileName, accounts);
    }
    
    public static void load() {
    	
    }
    
    private static boolean ifFileExists() {
		return new File(fileName).exists();
	}
}
