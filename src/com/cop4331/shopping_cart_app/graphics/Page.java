/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics;

import javax.swing.JPanel;
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
	
	/**
	 * @return
	 */
	protected Window getWindow() {
		return (Window) SwingUtilities.getWindowAncestor(this);
	}

	/**
	 * 
	 */
	protected void load() {
		System.out.println("Loading Page "+this.getClass().getName());
	}
}
