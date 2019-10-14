/**
 * 
 */
package com.shopping_cart_app.graphics;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.shopping_cart_app.core.App;

/**
 * @author mmena2017
 *
 */
public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @throws HeadlessException
	 */
	public Window() throws HeadlessException {
		// TODO Auto-generated constructor stub
		setSize(App.WINDOW_WIDTH,App.WINDOW_HEIGHT);
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

}
