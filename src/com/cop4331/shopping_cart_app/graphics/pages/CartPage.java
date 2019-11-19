package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cop4331.shopping_cart_app.backend.Item;
import com.cop4331.shopping_cart_app.backend.ItemDB;
import com.cop4331.shopping_cart_app.core.Session;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;

public class CartPage extends Page {

	JPanel itemContainerPanel;
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
		
		headPanel.add(Box.createHorizontalStrut(30));// creates gap
		
		JButton KeepShoppingBtn = new JButton();
		KeepShoppingBtn.setPreferredSize(new Dimension(125,75));
		KeepShoppingBtn.setText("Keep Shopping");
		headPanel.add(KeepShoppingBtn);
		
		Page pageinQuestion = this;
		
		KeepShoppingBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWindow().SetPage(PageManager.getPageIndex(pageinQuestion)-1);
			}
		});
		
		
		JButton checkoutBtn = new JButton();
		checkoutBtn.setPreferredSize(new Dimension(125,75));
		checkoutBtn.setText("Checkout");
		headPanel.add(checkoutBtn);
		
		checkoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWindow().SetPage(PageManager.getPageIndex(pageinQuestion)+1);
			}
		});
	}
	/**
	 * 
	 */
	private void BuildContentPanel() {
		JPanel contentPanel = new JPanel(new FlowLayout());
		contentPanel.setBackground(Color.gray);
		add(contentPanel,BorderLayout.CENTER);
		
		
		FlowLayout itemContainer_Layout = new FlowLayout();
		itemContainerPanel =  new JPanel(itemContainer_Layout);
		itemContainerPanel.setBackground(Color.black);
		
		JScrollPane scrollableItemContainer = new JScrollPane(itemContainerPanel);
		scrollableItemContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollableItemContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableItemContainer.setPreferredSize(new Dimension(1200,550));
		contentPanel.add(scrollableItemContainer);
		
	}
	/**
	 * 
	 */
	private void BuildItemContainer() {
		
		//contentPanel.add(itemContainerPanel);
		
		itemContainerPanel.removeAll();
		
		HashMap<Integer,Integer> cart = (HashMap<Integer, Integer>) Session.getCookie("cart");
		Object[] keyset = cart.keySet().toArray();
		for (int i = 0; i < keyset.length; i++) {
			
			Item item = ItemDB.getItem((int) keyset[i]);
			JPanel itemPanel = createItem(item,cart.get(keyset[i]));
			itemPanel.setPreferredSize(new Dimension(1100, 100));
			itemContainerPanel.add(itemPanel);
		}
		
		FlowLayout itemContainer_Layout = (FlowLayout) itemContainerPanel.getLayout();
		int totalHeight = itemContainer_Layout .getHgap() +(100 + itemContainer_Layout.getHgap()) * keyset.length;
		itemContainerPanel.setPreferredSize(new Dimension(1200,totalHeight));
	}
	/**
	 * @param q 
	 * @return
	 */
	private JPanel createItem(Item i,int qual) {
		JPanel item = new JPanel(new GridLayout(1,2));
		
		JLabel itemName = new JLabel(i.getName(), SwingConstants.CENTER);
		item.add(itemName);
		
		JLabel sellerName = new JLabel(Integer.toString(i.getSellerID()), SwingConstants.CENTER);
		item.add(sellerName);
		
		JLabel quantity = new JLabel(Integer.toString(qual), SwingConstants.CENTER);
		item.add(quantity);
		
		JButton addBtn = new JButton("Add ( $" + i.getPrice()+ " )");
		item.add(addBtn);
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer,Integer> cart = (HashMap<Integer, Integer>) Session.getCookie("cart");
				
				if(cart.containsKey(i.getSellerID())) {
					cart.put(i.getSellerID(), cart.get(i.getSellerID()) + 1 );
				}
				else {
					cart.put(i.getSellerID(), 1)	;
				}
				
				quantity.setText(Integer.toString(cart.get(i.getSellerID())));
				
			}
		});
		
		JButton deleteBtn = new JButton("Delete");
		item.add(deleteBtn);
		
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer,Integer> cart = (HashMap<Integer, Integer>) Session.getCookie("cart");
				
				if(cart.containsKey(i.getSellerID())) {
					
					if(cart.get(i.getSellerID()) > 0) {
						cart.put(i.getSellerID(), cart.get(i.getSellerID()) - 1 );
						quantity.setText(Integer.toString(cart.get(i.getSellerID())));
					}
					
					if(cart.get(i.getSellerID()) < 1){
						cart.remove(i.getSellerID());
						//BuildItemContainer();
						//getWindow().repaint();
					}
						
				}
				
			}
		});
		
		return item;
	}

	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#load()
	 */
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		super.load();
		BuildItemContainer();
	}
}
