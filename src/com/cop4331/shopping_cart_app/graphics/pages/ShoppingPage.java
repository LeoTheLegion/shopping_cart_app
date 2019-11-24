package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.cop4331.shopping_cart_app.core.Authenticator;
import com.cop4331.shopping_cart_app.core.Item;
import com.cop4331.shopping_cart_app.core.ItemDB;
import com.cop4331.shopping_cart_app.core.Session;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;
import com.cop4331.shopping_cart_app.graphics.windowmanager.WindowManager;

public class ShoppingPage extends Page {
	
	JPanel itemContainerPanel;
	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#buildPage(com.shopping_cart_app.graphics.Window)
	 */
	@Override
	protected void buildPage() {
		// TODO Auto-generated method stub
		
		setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		
		HashMap<Integer,Integer> cart = new HashMap<Integer,Integer>();//<itemid,quality>
		
		Session.createCookie("cart", cart);
		
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
		
		Page pageinQuestion = this;
		
		cartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWindow().SetPage(PageManager.getInstance().getPageIndex(pageinQuestion)+1);
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
		
		
		itemContainerPanel =  new JPanel(new FlowLayout());
		itemContainerPanel.setBackground(Color.black);
		
		BuildItemContainer();
		
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
		
		itemContainerPanel.removeAll();
		
		List<Item> itemsSearched = ItemDB.getFullInventory();
		
		for (int i = 0; i < itemsSearched.size(); i++) {
			JPanel item = createItem(itemsSearched.get(i));
			item.setPreferredSize(new Dimension(1100, 100));
			itemContainerPanel.add(item);
		}
		
		int totalHeight = ((FlowLayout) itemContainerPanel.getLayout()).getHgap() +(100 + ((FlowLayout) itemContainerPanel.getLayout()).getHgap()) * itemsSearched.size();
		itemContainerPanel.setPreferredSize(new Dimension(1200,totalHeight));
	}
	/**
	 * @return
	 */
	private JPanel createItem(Item i) {
		JPanel item = new JPanel(new GridLayout(1,2));
		
		JLabel itemName = new JLabel(i.getName(), SwingConstants.CENTER);
		item.add(itemName);
		
		itemName.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int popUpPageID = 4;
				DescriptionPage d = (DescriptionPage) PageManager.getInstance().getPage(popUpPageID);
				d.setItemToDisplay(i);
				
				WindowManager.createNewWindow(popUpPageID, 500, 700);
			}
		});
		
		JLabel sellerName = new JLabel(Integer.toString(i.getSellerID()), SwingConstants.CENTER);
		item.add(sellerName);
		
		JLabel quantity = new JLabel(Integer.toString(i.getQuantity()), SwingConstants.CENTER);
		item.add(quantity);
		
		JButton addToCartBtn = new JButton("Add To Cart ( $" + i.getPrice()+ " )");
		item.add(addToCartBtn);
		
		addToCartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer,Integer> cart = (HashMap<Integer, Integer>) Session.getCookie("cart");
				
				int itemID = ItemDB.getItemID(i);
				
				
				
				if(cart.containsKey(itemID)) {
					cart.put(itemID, cart.get(itemID) + 1 );
				}
				else {
					cart.put(itemID, 1)	;
				}
					
			}	
			;
			
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
