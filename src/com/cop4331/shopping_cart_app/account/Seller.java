package com.cop4331.shopping_cart_app.account;

import java.text.DecimalFormat;

public class Seller extends Account {

	private double revenue;
	private double cost;
	
	public Seller(String username, String password, double revenue, double cost) {
		this.username = username;
		this.password = password;
		this.revenue=revenue;
		this.cost=cost;
	}
	
	public String getRevenue() {
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.revenue);
	}
	
	
	public String getCost() {
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.cost);
	}

	public String getProfit() {
		// TODO Auto-generated method stub
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.revenue-this.cost);
	}

	public void addRev(double revenue) {
		// TODO Auto-generated method stub
		this.revenue+=revenue;
	}
	
	public void addCost(double cost) {
		this.cost+=cost;
	}
}
