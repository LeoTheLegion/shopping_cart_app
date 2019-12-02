/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cop4331.shopping_cart_app.backend.Account;
import com.cop4331.shopping_cart_app.backend.AccountDB;
import com.cop4331.shopping_cart_app.backend.Customer;
import com.cop4331.shopping_cart_app.core.Authenticator;
import com.cop4331.shopping_cart_app.core.Session;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;

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
		this.setLayout(new FlowLayout());
		
		JPanel mainPanel = new JPanel(new GridLayout(3,1));
		mainPanel.setPreferredSize(new Dimension(500,700));
		mainPanel.setBackground(getBackground());
		
		JTextField userField = new JTextField("michael", SwingConstants.CENTER);
		JTextField passField = new JTextField("1234", SwingConstants.CENTER);
		JButton loginBtn = new JButton();
		
		loginBtn.setText("Login in");
		
		Page pageinQuestion = this;
		
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				String user = userField.getText();
				String pass = passField.getText();
				
				int accountID = AccountDB.getAccountID(user, pass);
				
				if (accountID >= 0) {
					Account a = AccountDB.getAccount(accountID);
					
					if(a instanceof Customer)
						getWindow().SetPage(1);
					else
						getWindow().SetPage(5);
					
					AccountDB.CURRENTACCOUNT_ID = accountID;
				}
				
//				if(pass.equals("s")) {//temp code
//					getWindow().SetPage(5);
//					return;
//				}
//				
//				if(Authenticator.Auth(user, pass)) {
//					Session.createCookie("username", user);
//					Session.createCookie("password", pass);
//					
//					getWindow().SetPage(1);
//				}
				
				
			}
		
		});
		
		mainPanel.add(userField);
		mainPanel.add(passField);
		mainPanel.add(loginBtn);
		
		
		add(mainPanel);
	}
	
	
	

}
