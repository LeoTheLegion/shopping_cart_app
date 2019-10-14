/**
 * 
 */
package com.shopping_cart_app.graphics;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author mmena2017
 *
 */
public class Page extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Page(Window win) {
		// TODO Auto-generated constructor stub
		super(null);
		setBounds(0, 0,win.getWidth(), win.getHeight());
		buildPage(win);
		win.repaint();
	}

	/**
	 * 
	 */
	private void buildPage(Window win) {
		
		//win.setLayout(new BorderLayout());
		
		setBackground(Color.BLACK);
		
		JPanel testpanel = new JPanel(new GridLayout(3,1));
		testpanel.setBounds(this.getWidth()/3, 0, this.getWidth()/3, this.getHeight());
		
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
