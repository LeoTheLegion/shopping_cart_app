package com.cop4331.shopping_cart_app.backend;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSaveAccounts implements ISave<Account> {
	
	@Override
	public void save(String fileName, ArrayList<Account> accountList) {
		
		JSONArray Json_account_list=new JSONArray();
		for(int i=0; i<accountList.size(); i++) {
			JSONObject jsonAcc=new JSONObject();
			
			Account account = accountList.get(i);
			
			jsonAcc.put("username", account.getUsername());
			jsonAcc.put("password", account.getPassword());
			jsonAcc.put("acc_type", account.getAccType());
			
			if(account instanceof Customer) {
				jsonAcc.put("cart", ((Customer) account).cartToString());
			}
			
			System.out.println("Saving user: "+ jsonAcc.toString());
			
			Json_account_list.add(jsonAcc);
		}
		PrintWriter writer=null;
		try {
			writer=new PrintWriter(fileName);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		
		writer.write(Json_account_list.toString());
		writer.flush();
		writer.close();
	}

}
