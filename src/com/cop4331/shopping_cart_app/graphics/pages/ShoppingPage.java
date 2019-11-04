package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.cop4331.shopping_cart_app.core.Session;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;

public class ShoppingPage extends Page {

	JLabel test1,test2;
	
	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#buildPage(com.shopping_cart_app.graphics.Window)
	 */
	@Override
	protected void buildPage() {
		// TODO Auto-generated method stub
		
		setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		
		BuildHeadPanel();
		BuildContentPanel();
	}
	/**
	 * 
	 */
	private void BuildHeadPanel() {
		JPanel headPanel = new JPanel(new FlowLayout());
		headPanel.setBackground(Color.green);
		add(headPanel,BorderLayout.PAGE_START);
		
		
		JTextField searchField = new JTextField("dawdawdw");
		searchField.setPreferredSize(new Dimension(1000,50));
		headPanel.add(searchField);
		
		headPanel.add(Box.createHorizontalStrut(30));// creates gap
		
		JButton cartBtn = new JButton();
		cartBtn.setPreferredSize(new Dimension(125,75));
		cartBtn.setText("cart");
		headPanel.add(cartBtn);
		
	}
	/**
	 * 
	 */
	private void BuildContentPanel() {
		JPanel contentPanel = new JPanel(new FlowLayout());
		contentPanel.setBackground(Color.gray);
		add(contentPanel,BorderLayout.CENTER);
		
		
		FlowLayout itemContainer_Layout = new FlowLayout();
		JPanel itemContainerPanel =  new JPanel(itemContainer_Layout);
		itemContainerPanel.setBackground(Color.black);
		//contentPanel.add(itemContainerPanel);
		
		int numOfItemsToDisplay = 10;
		
		for (int i = 0; i < numOfItemsToDisplay; i++) {
			JPanel item = createItem();
			item.setPreferredSize(new Dimension(1100, 100));
			itemContainerPanel.add(item);
		}
		
		int totalHeight = itemContainer_Layout.getHgap() +(100 + itemContainer_Layout.getHgap()) * numOfItemsToDisplay;
		itemContainerPanel.setPreferredSize(new Dimension(1200,totalHeight));
		
		JScrollPane scrollableItemContainer = new JScrollPane(itemContainerPanel);
		scrollableItemContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollableItemContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableItemContainer.setPreferredSize(new Dimension(1200,550));
		contentPanel.add(scrollableItemContainer);
		
	}
	/**
	 * @return
	 */
	private JPanel createItem() {
		JPanel item = new JPanel(new GridLayout(1,2));
		
		JLabel itemName = new JLabel("item_name");
		item.add(itemName);
		
		JButton addToCartBtn = new JButton("Add To Cart");
		item.add(addToCartBtn);
		
		return item;
	}

	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#load()
	 */
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		super.load();
	}

}
