package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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

public class CheckOutPage extends Page {
	
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
		
		JButton backToCheckOutBtn = new JButton();
		backToCheckOutBtn.setPreferredSize(new Dimension(125,75));
		backToCheckOutBtn.setText("Back To Check Out");
		headPanel.add(backToCheckOutBtn);
		
		Page pageinQuestion = this;
		
		backToCheckOutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWindow().SetPage(PageManager.getInstance().getPageIndex(pageinQuestion)-1);
			}
		});
		
		
		JButton payBtn = new JButton();
		payBtn.setPreferredSize(new Dimension(125,75));
		payBtn.setText("Pay");
		headPanel.add(payBtn);
		
		payBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				HashMap<Integer,Integer> cart = new HashMap<Integer,Integer>();//<itemid,quality>
				
				Session.createCookie("cart", cart);
				
				getWindow().SetPage(1);
				
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
		scrollableItemContainer.setPreferredSize(new Dimension(400,550));
		contentPanel.add(scrollableItemContainer);
		
		
		JPanel formPanel = new JPanel(new FlowLayout());
		formPanel.setBackground(Color.LIGHT_GRAY);
		formPanel.setPreferredSize(new Dimension(400,550));
		contentPanel.add(formPanel);
		
		JPanel test = createFormInput("test",300, 50,0.3f);
		formPanel.add(test);
		
		JPanel test2 = createFormInput("test2",140, 50,0.5f);
		formPanel.add(test2);
		
		JPanel test3 = createFormInput("test3",140, 50,0.5f);
		formPanel.add(test3);
	}
	/**
	 * @param labelWidthPercentage 
	 * @param di 
	 * @param text 
	 * @return
	 */
	private JPanel createFormInput(String text, int width, int height, float labelWidthPercentage) {
		JPanel input = new JPanel(new FlowLayout());
		input.setPreferredSize(new Dimension(width, height));
		
		JLabel lab = new JLabel(text, SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension((int) (width*labelWidthPercentage - 5),(int) (height* 0.9 -2.5)));
		lab.setBackground(Color.BLUE);
		input.add(lab);
		
		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension((int) (width*(1-labelWidthPercentage)- 5),(int) (height* 0.9 -2.5)));
		input.add(field);
		
		return input;
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
			itemPanel.setPreferredSize(new Dimension(300, 100));
			itemContainerPanel.add(itemPanel);
		}
		
		FlowLayout itemContainer_Layout = (FlowLayout) itemContainerPanel.getLayout();
		int totalHeight = itemContainer_Layout .getHgap() +(100 + itemContainer_Layout.getHgap()) * keyset.length;
		itemContainerPanel.setPreferredSize(new Dimension(400,totalHeight));
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
