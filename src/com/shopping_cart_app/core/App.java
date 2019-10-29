package com.shopping_cart_app.core;

import java.util.ArrayList;
import java.util.List;

import com.shopping_cart_app.graphics.Page;
import com.shopping_cart_app.graphics.Window;
import com.shopping_cart_app.graphics.PageManagement.PageManager;
import com.shopping_cart_app.graphics.PageManagement.Pages.TestPage;
import com.shopping_cart_app.graphics.WindowManagement.WindowManager;

public class App {
	
	public static final int WINDOW_WIDTH = 1280;/// CHANGE RES HERE ONLY!
	public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9; // 16 by 9 aspect ratio
	
	public App() {		
		
		Session.createNewSession();
		
		PageManager.init();
		WindowManager.init();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App();
	}

}
