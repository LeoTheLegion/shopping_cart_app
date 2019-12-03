package com.cop4331.shopping_cart_app.account;

import java.text.DecimalFormat;

public class Seller extends Account {

	private double revenue;
	private double cost;
	
	/**
	 * @param username
	 * @param password
	 * @param revenue
	 * @param cost
	 */
	public Seller(String username, String password, double revenue, double cost) {
		super(username,password);
		this.revenue=revenue;
		this.cost=cost;
	}
	
	/**
	 * @return
	 */
	public String getRevenue() {
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.revenue);
	}
	
	
	/**
	 * @return
	 */
	public String getCost() {
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.cost);
	}

	/**
	 * @return
	 */
	public String getProfit() {
		// TODO Auto-generated method stub
		DecimalFormat form=new DecimalFormat("0.00");
		return form.format(this.revenue-this.cost);
	}

	/**
	 * @param revenue
	 */
	public void addRev(double revenue) {
		// TODO Auto-generated method stub
		this.revenue+=revenue;
	}
	
	/**
	 * @param cost
	 */
	public void addCost(double cost) {
		this.cost+=cost;
	}
}
