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
		
		getMainWindow().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}


	public static void createNewWindow(int pageIndex) {
		createNewWindow(pageIndex,App.WINDOW_WIDTH,App.WINDOW_HEIGHT);
	}
	
	public static void createNewWindow(int pageIndex,int width,int height) {
		// TODO Auto-generated method stub
		System.out.println("Building new window :" + 
				((windows.size() == 0) ? "(MAIN)" : "(POPUP)")
		);
		Window w = new Window();

		w.setSize(width,height);
		
		w.SetPage(pageIndex);
		windows.add(w);
	}

	/**
	 * @return
	 */
	public static Window getMainWindow() {
		return windows.get(0);
	}
}
