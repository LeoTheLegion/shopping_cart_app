package com.cop4331.shopping_cart_app.backend;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSaveAccounts implements ISave<Account> {
	
	@Override
	public void save(String fileName, ArrayList<Account> acc) {
		
		JSONArray account_list=new JSONArray();
		for(int i=0; i<acc.size(); i++) {
			JSONObject account=new JSONObject();
			account.put("username", acc.get(i).getUsername());
			account.put("password", acc.get(i).getPassword());
			account.put("acc_type", acc.get(i).getAccType());
			System.out.println("Saving user: "+ account.toString());
			
			account_list.add(account);
		}
		PrintWriter writer=null;
		try {
			writer=new PrintWriter(fileName);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		
		writer.write(account_list.toString());
		writer.flush();
		writer.close();
	}

}
