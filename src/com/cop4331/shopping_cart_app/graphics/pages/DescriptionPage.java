/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.cop4331.shopping_cart_app.backend.Item;
import com.cop4331.shopping_cart_app.backend.ItemDB;
import com.cop4331.shopping_cart_app.graphics.IPopUp;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.windowmanager.WindowManager;

/**
 * @author mmena2017
 *
 */
public class DescriptionPage extends Page implements IPopUp {

	Item item;
	JLabel itemName,sellerName,itemDescription;
	/* (non-Javadoc)
	 * @see com.cop4331.shopping_cart_app.graphics.Page#buildPage()
	 */
	@Override
	protected void buildPage() {
		// TODO Auto-generated method stub
		super.buildPage();
		
		this.setLayout(new FlowLayout());
		
		itemName = new JLabel("NULL", SwingConstants.CENTER);	
		itemName.setPreferredSize(new Dimension(400,100));
		
		Font itemTitle = new Font("serif", Font.BOLD, 28);
		itemName.setFont(itemTitle);
		
		add(itemName);
		
		sellerName = new JLabel("NULL", SwingConstants.CENTER);
		sellerName.setPreferredSize(new Dimension(400,100));
		add(sellerName);
		
		itemDescription = new JLabel("NULL", SwingConstants.CENTER);
		itemDescription.setPreferredSize(new Dimension(400,100));
		add(itemDescription);
		
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.cop4331.shopping_cart_app.graphics.Page#load()
	 */
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		super.load();
		
		itemName.setText(item.getName()); 
		sellerName.setText("Sold by "+ Integer.toString(item.getSellerID())); 
		itemDescription.setText(item.getDescription()); 
	}
	
	public void setItemToDisplay(Item i) {
		this.item = i;
	}
}
