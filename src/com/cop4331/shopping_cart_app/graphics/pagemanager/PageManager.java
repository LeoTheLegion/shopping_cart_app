/**
 * 
 */
package com.cop4331.shopping_cart_app.graphics.pagemanager;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.cop4331.shopping_cart_app.graphics.Page;
import com.cop4331.shopping_cart_app.graphics.pages.*;

/**
 * @author mmena2017
 *
 */
public class PageManager {
	
	static List<Page> pages;
	
	public static void init() {
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
	private static void LoadPage(Page p) {
		System.out.println("Building Page " + p.getClass() + ". Assigning to pageIndex:" + pages.size() );
		pages.add(p);
	}

	public static Page getPage(int pageIndex) {
		// TODO Auto-generated method stub
		
		if(pageIndex >= pages.size())/// <------creates page loop
			return pages.get(0);
		
		return pages.get(pageIndex);
	}

	public static int getPageIndex(Page page) {
		for (int i = 0; i < pages.size(); i++) {
			if(getPage(i) == page)
				return i;
		}
		return -1;
	}
	
	
}
