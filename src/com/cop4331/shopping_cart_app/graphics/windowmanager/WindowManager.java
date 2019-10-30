/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics.windowmanager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.WindowConstants;

import com.cop4331.shopping_cart_app.App;
import com.cop4331.shopping_cart_app.graphics.Window;

/**
 * @author mmena2017
 *
 */
public class WindowManager {
	static List<Window> windows;
	
	
	public static void init() {
		windows = new ArrayList<Window>();
		
		createNewWindow(0);
		
		windows.get(0).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}


	private static void createNewWindow(int pageIndex) {
		// TODO Auto-generated method stub
		System.out.println("Building new window" );
		Window w = new Window();

		w.setSize(App.WINDOW_WIDTH,App.WINDOW_HEIGHT);
		
		w.SetPage(pageIndex);
		windows.add(w);
	}


	/**
	 * @return
	 */
	public Window getMainWindow() {
		return windows.get(0);
	}
}
