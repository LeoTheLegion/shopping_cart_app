package com.cop4331.shopping_cart_app.backend;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSaveAccounts implements ISave<Account> {
	
	@Override
	public void save(String fileName, ArrayList<Account> accountList) {
		
		//JSONArray account_list=new JSONArray();
		for(int i=0; i<accountList.size(); i++) {
			JSONObject json=new JSONObject();
			
			Account account = accountList.get(i);
			
			json.put("username", account.getUsername());
			json.put("password", account.getPassword());
			json.put("acc_type", account.getAccType());
			
			if(account instanceof Customer) {
				json.put("cart", "0:5,1:5,2:5,3:5");
			}
			
			System.out.println("Saving user: "+ json.toString());
			
			//account_list.add(json);
		}
		PrintWriter writer=null;
		try {
			writer=new PrintWriter(fileName);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		
		//writer.write(account_list.toString());
		writer.flush();
		writer.close();
	}

}
