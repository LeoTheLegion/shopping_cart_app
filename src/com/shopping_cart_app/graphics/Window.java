/**
 * 
 */
package com.shopping_cart_app.graphics;

import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.shopping_cart_app.core.App;
import com.shopping_cart_app.graphics.PageManagement.PageManager;

/**
 * @author mmena2017
 *
 */
public class Window extends JFrame {

	/**
	 * 
	 */
	int currentPage = 0;
	private static final long serialVersionUID = 1L;
	/**
	 * @throws HeadlessException
	 */
	public Window() throws HeadlessException {
		// TODO Auto-generated constructor stub
		setLayout(null);  
		setVisible(true);
		
	}
	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public Window(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public void SetPage(int pageIndex) {
		this.getContentPane().removeAll();
		this.repaint();
		
		Page page = PageManager.getPage(pageIndex);
		
		System.out.println("Setting Page to " + page.getClass() );
		
		page.setBounds(0,0,this.getWidth(),this.getHeight());
		page.repaint();
		
		this.add(page);
		this.repaint();
		this.setVisible(true);
	}

}
