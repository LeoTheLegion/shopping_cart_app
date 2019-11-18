/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.cop4331.shopping_cart_app.App;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;

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
		page.load();
		
		page.setBounds(0,0,this.getWidth() - this.getInsets().left- this.getInsets().right,
				this.getHeight() - this.getInsets().top);
		
		page.repaint();
		
		this.add(page);
		this.repaint();
		this.setVisible(true);
	}
	public void close() {
		// TODO Auto-generated method stub
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}
