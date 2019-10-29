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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.shopping_cart_app.core.Session;
import com.shopping_cart_app.graphics.Page;
import com.shopping_cart_app.graphics.PageManagement.PageManager;

/**
 * @author mmena2017
 *
 */
public class LoginPage extends Page {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.shopping_cart_app.graphics.Page#buildPage()
	 */
	@Override
	protected void buildPage() {
		// TODO Auto-generated method stub
		super.buildPage();
		
		
		setBackground(Color.BLACK);
		this.setLayout(new GridLayout(1,3));
		
		JPanel testpanel = new JPanel(new GridLayout(3,1));
		
		testpanel.setBackground(getBackground());
		
		JTextField userField = new JTextField("A user name", SwingConstants.CENTER);
		JTextField passField = new JTextField("A password", SwingConstants.CENTER);
		JButton loginBtn = new JButton();
		
		loginBtn.setText("Login in");
		
		Page pageinQuestion = this;
		
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Session.createCookie("username", userField.getText());
				Session.createCookie("password", passField.getText());
				
				getWindow().SetPage(PageManager.getPageIndex(pageinQuestion)+1);
			}
		
		});
		
		testpanel.add(userField);
		testpanel.add(passField);
		testpanel.add(loginBtn);
		
		
		add(new JPanel());
		add(testpanel);
		add(new JPanel());
	}
	
	
	

}
