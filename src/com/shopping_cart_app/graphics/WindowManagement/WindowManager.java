/**
 * 
 */
package com.shopping_cart_app.graphics.WindowManagement;

import java.util.ArrayList;
import java.util.List;

import com.shopping_cart_app.core.App;
import com.shopping_cart_app.graphics.Window;

/**
 * @author mmena2017
 *
 */
public class WindowManager {
	static List<Window> windows;
	
	
	public static void init() {
		windows = new ArrayList<Window>();
		
		createNewWindow(0);
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
