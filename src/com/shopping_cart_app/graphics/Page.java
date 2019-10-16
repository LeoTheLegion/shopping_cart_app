/**
 * 
 */
package com.shopping_cart_app.graphics;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * @author mmena2017
 *
 */
public abstract class Page extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Page() {
		// TODO Auto-generated constructor stub
		super(null);
		buildPage();
	}

	/**
	 * 
	 */
	protected void buildPage() {
		
	}
	
	Window GetWindow() {
		return (Window) SwingUtilities.getWindowAncestor(this);
	}
}