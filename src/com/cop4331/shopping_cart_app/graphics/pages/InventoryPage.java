/**
 * 
 */
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
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.cop4331.shopping_cart_app.backend.Item;
import com.cop4331.shopping_cart_app.backend.ItemDB;
import com.cop4331.shopping_cart_app.core.Session;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;
import com.cop4331.shopping_cart_app.graphics.windowmanager.WindowManager;

/**
 * @author mmena2017
 *
 */
public class InventoryPage extends Page {

	private JPanel itemContainerPanel;
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
		
		JButton LogOutBtn = new JButton();
		LogOutBtn.setPreferredSize(new Dimension(125,75));
		LogOutBtn.setText("Login Out");
		headPanel.add(LogOutBtn);
		
		Page pageinQuestion = this;
		
		LogOutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getWindow().SetPage(0);
			}
		});
		
		
		JButton addNewItemBtn = new JButton();
		addNewItemBtn.setPreferredSize(new Dimension(125,75));
		addNewItemBtn.setText("Add Item");
		headPanel.add(addNewItemBtn);
		
		addNewItemBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(WindowManager.count() > 1) {
					System.err.println("you are already adding an item!");
					return;
				}
				
				int popUpPageID = 6;
				
				WindowManager.createNewWindow(popUpPageID, 500, 700);
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
		
		JLabel price = new JLabel(Double.toString(i.getPrice()), SwingConstants.CENTER);
		item.add(price);
		
		JTextField quantity = new JTextField(Integer.toString(i.getQuantity()), SwingConstants.CENTER);
		item.add(quantity);
		
		quantity.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				update();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				update();
			}
			
			void update() {
				int newQuantity = - 1;
				
				try {
					newQuantity = Integer.parseInt(quantity.getText());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.err.println("not a number");
					return;
				}
				
				if(newQuantity < 0) {
					System.err.println("can't have negatives");
					return;
				}
				
				int itemID = ItemDB.getItemID(i);
				ItemDB.setQuantity(itemID, newQuantity);
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
