package com.cop4331.shopping_cart_app;

import java.util.ArrayList;
import java.util.List;

import com.cop4331.shopping_cart_app.backend.ItemDB;
import com.cop4331.shopping_cart_app.core.Session;
import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.Window;
import com.cop4331.shopping_cart_app.graphics.pagemanager.PageManager;
import com.cop4331.shopping_cart_app.graphics.pages.TestPage;
import com.cop4331.shopping_cart_app.graphics.windowmanager.WindowManager;

public class App {
	
	public static final int WINDOW_WIDTH = 1280;/// CHANGE RES HERE ONLY!
	public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9; // 16 by 9 aspect ratio
	
	public App() {		
		
		ItemDB.init();
		
		Session.createNewSession();
		
		PageManager.init();
		WindowManager.init();
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App();
	}

}
