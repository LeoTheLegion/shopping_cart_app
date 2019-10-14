package com.shopping_cart_app.core;

import java.util.ArrayList;
import java.util.List;

import com.shopping_cart_app.graphics.Page;
import com.shopping_cart_app.graphics.Window;

public class App {
	
	public static final int WINDOW_WIDTH = 1280;/// CHANGE RES HERE ONLY!
	public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9; // 16 by 9 aspect ratio
	
	List<Window> windows = new ArrayList<Window>();
	
	public App() {
		windows.add(new Window());
		
		getMainWindow().add(new Page(getMainWindow()));
	}


	/**
	 * @return
	 */
	private Window getMainWindow() {
		return windows.get(0);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App();
	}

}
