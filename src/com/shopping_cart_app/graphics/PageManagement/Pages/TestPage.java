/**
 * 
 */
package com.shopping_cart_app.graphics.PageManagement.Pages;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.shopping_cart_app.graphics.Page;
import com.shopping_cart_app.graphics.Window;

/**
 * @author mmena2017
 *
 */
public class TestPage extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#buildPage(com.shopping_cart_app.graphics.Window)
	 */
	@Override
	protected void buildPage() {
		// TODO Auto-generated method stub
		
		setBackground(Color.BLACK);
		this.setLayout(new GridLayout(1,2));
		
		JPanel testpanel = new JPanel(new GridLayout(3,1));
		
		testpanel.setBackground(getBackground());
		
		JLabel test1 = new JLabel("THIS IS A BLANK PAGE", SwingConstants.CENTER);
		JLabel test2 = new JLabel("THIS IS A BLANK PAGE", SwingConstants.CENTER);
		JLabel test3 = new JLabel("THIS IS A BLANK PAGE", SwingConstants.CENTER);
		
		test1.setForeground(Color.WHITE);
		test2.setForeground(Color.WHITE);
		test3.setForeground(Color.WHITE);
		
		testpanel.add(test1);
		testpanel.add(test2);
		testpanel.add(test3);
		
		add(testpanel);
	}
}
