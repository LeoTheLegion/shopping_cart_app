/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics.pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cop4331.shopping_cart_app.account.Account;
import com.cop4331.shopping_cart_app.account.Customer;
import com.cop4331.shopping_cart_app.databases.AccountDB;
import com.cop4331.shopping_cart_app.graphics.Page;

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
		JPasswordField passField = new JPasswordField("1234", SwingConstants.CENTER);
		
		JLabel enterUser=new JLabel("Username: ",SwingConstants.RIGHT);
		JLabel enterPass=new JLabel("Password: ", SwingConstants.RIGHT);
		//OPTIONAL set text in the middle of text field
		userField.setHorizontalAlignment(JTextField.CENTER);
		passField.setHorizontalAlignment(JPasswordField.CENTER);
		
		//OPTIONAL adjust text size
		Font loginFont=new Font("SansSerif",Font.BOLD, 25);
		userField.setFont(loginFont);
		JButton loginBtn = new JButton();
		
		loginBtn.setText("Login");
		
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				String user = userField.getText();
				String pass = passField.getText();
				
				int accountID = AccountDB.getInstance().getAccountID(user, pass);
				
				if (accountID >= 0) {
					Account a = AccountDB.getInstance().getAccount(accountID);
					
					AccountDB.getInstance().currentAccount_ID = accountID;
					
					if(a instanceof Customer)
						getWindow().SetPage(1);
					else
						getWindow().SetPage(5);
					
					
				}
				
			}
		
		});

		mainPanel.add(userField);
		mainPanel.add(passField);
		mainPanel.add(loginBtn);
		add(mainPanel);
	}
	

}
