/**
 * 
 */
package com.shopping_cart_app.graphics.PageManagement.Pages;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.shopping_cart_app.core.Session;
import com.shopping_cart_app.graphics.Page;
import com.shopping_cart_app.graphics.Window;
import com.shopping_cart_app.graphics.PageManagement.PageManager;

/**
 * @author mmena2017
 *
 */
public class TestPage extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel test1,test2;

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
		
		test1 = new JLabel("THIS IS A TEST PAGE", SwingConstants.CENTER);
		test2 = new JLabel("THIS IS A TEST PAGE", SwingConstants.CENTER);
		JButton testBtn = new JButton();
		
		test1.setForeground(Color.WHITE);
		test2.setForeground(Color.WHITE);
		testBtn.setText("Next Page");
		
		Page pageinQuestion = this;
		
		testBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getWindow().SetPage(PageManager.getPageIndex(pageinQuestion)+1);
			}
		
		});
		
		testpanel.add(test1);
		testpanel.add(test2);
		testpanel.add(testBtn);
		
		add(testpanel);
	}

	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#load()
	 */
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		super.load();
		
		test2.setText((String) Session.getCookie("username"));
	}
	
	
}
