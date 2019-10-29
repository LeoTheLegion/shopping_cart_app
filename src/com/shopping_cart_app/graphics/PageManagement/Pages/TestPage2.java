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
import com.shopping_cart_app.graphics.PageManagement.PageManager;

/**
 * @author mmena2017
 *
 */
public class TestPage2 extends Page {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#buildPage(com.shopping_cart_app.graphics.Window)
	 */
	@Override
	protected void buildPage() {
		// TODO Auto-generated method stub
		
		setBackground(Color.gray);
		this.setLayout(new GridLayout(1,2));
		
		JPanel testpanel = new JPanel(new GridLayout(3,1));
		
		testpanel.setBackground(getBackground());
		
		JLabel test1 = new JLabel("THIS IS A TEST PAGE", SwingConstants.CENTER);
		JLabel test2 = new JLabel((String) Session.getCookie("Test2"), SwingConstants.CENTER);
		
		test1.setForeground(Color.WHITE);
		test2.setForeground(Color.WHITE);
		
		JButton testBtn = new JButton();
		
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
	
}
