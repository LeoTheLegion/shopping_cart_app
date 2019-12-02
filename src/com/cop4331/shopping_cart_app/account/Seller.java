package com.cop4331.shopping_cart_app.account;

import java.text.DecimalFormat;

public class Seller extends Account {

	private double profit;
	private double cost;
	
	public Seller(String username, String password, double profit, double cost) {
		this.username = username;
		this.password = password;
		this.profit=profit;
		this.cost=cost;
	}

	public void addProfit(double profit) {
		// TODO Auto-generated method stub
		this.profit+=profit;
	}
	
	public String getProfit() {
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.profit);
	}
	
	public void addCost(double cost) {
		this.cost+=cost;
	}
	
	public String getCost() {
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.cost);
	}

	public String getRev() {
		// TODO Auto-generated method stub
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.profit+this.cost);
	}
	
}
