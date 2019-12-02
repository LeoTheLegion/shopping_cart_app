package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cop4331.shopping_cart_app.backend.AccountDB;
import com.cop4331.shopping_cart_app.backend.Customer;
import com.cop4331.shopping_cart_app.backend.Item;
import com.cop4331.shopping_cart_app.backend.ItemDB;
import com.cop4331.shopping_cart_app.core.Session;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;
import com.cop4331.shopping_cart_app.graphics.windowmanager.WindowManager;

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
		headPanel.setBackground(new Color(43f/255f,105f/255f,128f/255f));
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
				getWindow().SetPage(PageManager.getInstance().getPageIndex(pageinQuestion)-1);
			}
		});
		
		
		JButton checkoutBtn = new JButton();
		checkoutBtn.setPreferredSize(new Dimension(125,75));
		checkoutBtn.setText("Checkout");
		headPanel.add(checkoutBtn);
		
		checkoutBtn.addActionListener(new ActionListener() {
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
		contentPanel.setOpaque(false);
		add(contentPanel,BorderLayout.CENTER);
		
		contentPanel.add(createItemContainerHeader());
		
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
	 */
	private JPanel createItemContainerHeader() {
		JPanel ItemContainerHeader = new JPanel(new GridLayout(1,2));
		
		JLabel itemName = new JLabel("Name", SwingConstants.CENTER);
		itemName.setBackground(Color.white);
		itemName.setOpaque(true);
		ItemContainerHeader.add(itemName);
		
		JLabel seller = new JLabel("Sold by", SwingConstants.CENTER);
		seller.setBackground(Color.white);
		seller.setOpaque(true);
		ItemContainerHeader.add(seller);
		
		JLabel quantity = new JLabel("Quantity", SwingConstants.CENTER);
		quantity.setBackground(Color.white);
		quantity.setOpaque(true);
		ItemContainerHeader.add(quantity);
		
		ItemContainerHeader.add(Box.createHorizontalStrut(30));
		ItemContainerHeader.add(Box.createHorizontalStrut(30));
		
		ItemContainerHeader.setOpaque(false);
		ItemContainerHeader.setPreferredSize(new Dimension(1100, 25));
		
		return ItemContainerHeader;
	}
	/**
	 * 
	 */
	private void BuildItemContainer() {
		
		//contentPanel.add(itemContainerPanel);
		
		itemContainerPanel.removeAll();
		
		HashMap<Integer,Integer> cart = ((Customer)AccountDB.getAccount(AccountDB.CURRENTACCOUNT_ID)).cart;
		Object[] keyset = cart.keySet().toArray();
		for (int i = 0; i < keyset.length; i++) {
			int itemID = (int) keyset[i];
			JPanel itemPanel = createItem(itemID,cart.get(keyset[i]));
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
	private JPanel createItem(int itemID,int qual) {
		Item i = ItemDB.getItem(itemID);
		JPanel itemDisplay = new JPanel(new GridLayout(1,2));
		
		JLabel itemName = new JLabel(i.getName(), SwingConstants.CENTER);
		Font itemTitle =  itemName.getFont();
		Map attributes = itemTitle.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		itemName.setForeground (Color.blue);
		itemName.setFont(itemTitle.deriveFont(attributes));
		itemDisplay.add(itemName);
		
		itemName.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int popUpPageID = 4;
				DescriptionPage d = (DescriptionPage) PageManager.getInstance().getPage(popUpPageID);
				d.setItemToDisplay(i);
				
				WindowManager.getInstance().createNewWindow(popUpPageID, 500, 700);
			}
		});
		
		JLabel sellerName = new JLabel(AccountDB.getAccount(i.getSellerID()).getUsername(), SwingConstants.CENTER);
		itemDisplay.add(sellerName);
		
		JLabel quantity = new JLabel(Integer.toString(qual), SwingConstants.CENTER);
		itemDisplay.add(quantity);
		
		JButton addBtn = new JButton("Add ( $" + i.getPrice()+ " )");
		itemDisplay.add(addBtn);
		
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer,Integer> cart = ((Customer)AccountDB.getAccount(AccountDB.CURRENTACCOUNT_ID)).cart;
				
				if(cart.containsKey(itemID)) {
					cart.put(itemID, cart.get(itemID) + 1 );
					
				}
				else {
					cart.put(itemID, 1)	;
					System.out.println("dwadw");
				}

				quantity.setText(Integer.toString(cart.get(itemID)));
				AccountDB.save();
			}
		});
		
		JButton deleteBtn = new JButton("Delete");
		itemDisplay.add(deleteBtn);
		
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer,Integer> cart = ((Customer)AccountDB.getAccount(AccountDB.CURRENTACCOUNT_ID)).cart;
				
				if(cart.containsKey(itemID)) {
					
					if(cart.get(itemID) > 0) {
						cart.put(itemID, cart.get(itemID) - 1 );
						quantity.setText(Integer.toString(cart.get(itemID)));
					}
					
					if(cart.get(itemID) < 1){
						cart.remove(itemID);
						//BuildItemContainer();
						//getWindow().repaint();
					}
						
				}
				AccountDB.save();
			}
		});
		
		return itemDisplay;
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
