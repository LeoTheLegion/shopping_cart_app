package com.cop4331.shopping_cart_app.account;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.*;

import com.cop4331.shopping_cart_app.filemanager.ISave;

public class JsonSaveAccounts implements ISave<Account> {
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void save(String fileName, ArrayList<Account> accountList) {
		
		JSONArray Json_account_list=new JSONArray();
		for(int i=0; i<accountList.size(); i++) {
			JSONObject jsonAcc=new JSONObject();
			
			Account account = accountList.get(i);
			
			jsonAcc.put("username", account.getUsername());
			jsonAcc.put("password", account.getPassword());
			
			
			if(account instanceof Customer) {
				jsonAcc.put("acc_type", "0");
				jsonAcc.put("cart", ((Customer) account).cartToString());
			}
			else {
				jsonAcc.put("revenue", ((Seller) account).getRevenue());
				jsonAcc.put("cost", ((Seller) account).getCost());
				jsonAcc.put("acc_type", "1");
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
