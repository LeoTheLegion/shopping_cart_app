/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics.pagemanager;

import java.util.ArrayList;
import java.util.List;

import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pages.AddItemPage;
import com.cop4331.shopping_cart_app.graphics.pages.CartPage;
import com.cop4331.shopping_cart_app.graphics.pages.CheckOutPage;
import com.cop4331.shopping_cart_app.graphics.pages.DescriptionPage;
import com.cop4331.shopping_cart_app.graphics.pages.InventoryPage;
import com.cop4331.shopping_cart_app.graphics.pages.LoginPage;
import com.cop4331.shopping_cart_app.graphics.pages.ShoppingPage;

/**
 * @author mmena2017
 *
 */
public class PageManager {
	
	private List<Page> pages;
	private static PageManager INSTANCE = null;
	
	/**
	 * 
	 */
	private PageManager() {
		pages = new ArrayList<Page>();
		LoadPage(new LoginPage());
		
		//buyer
		LoadPage(new ShoppingPage());
		LoadPage(new CartPage());
		LoadPage(new CheckOutPage());
		LoadPage(new DescriptionPage());
		
		//seller
		LoadPage(new InventoryPage());
		LoadPage(new AddItemPage());
	}
	
	/**
	 * 
	 */
	public static void init() {
		getInstance();
	}
	
	/**
	 * @return
	 */
	public static PageManager getInstance() {
		if(INSTANCE == null) {
			synchronized(PageManager.class) {
				if(INSTANCE == null)
					INSTANCE = new PageManager();
			}
		}
		return INSTANCE;
	}
	/**
	 * @param p
	 */
	private void LoadPage(Page p) {
		System.out.println("Building Page " + p.getClass() + ". Assigning to pageIndex:" + pages.size() );
		pages.add(p);
	}

	/**
	 * @param pageIndex
	 * @return
	 */
	public Page getPage(int pageIndex) {
		// TODO Auto-generated method stub
		
		if(pageIndex >= pages.size())/// <------creates page loop
			return pages.get(0);
		
		return pages.get(pageIndex);
	}

	/**
	 * @param page
	 * @return
	 */
	public int getPageIndex(Page page) {
		for (int i = 0; i < pages.size(); i++) {
			if(getPage(i) == page)
				return i;
		}
		return -1;
	}
	
	
}
