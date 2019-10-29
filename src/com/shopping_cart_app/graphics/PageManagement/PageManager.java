/**
 * 
 */
package com.shopping_cart_app.graphics.PageManagement;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.shopping_cart_app.graphics.Page;
import com.shopping_cart_app.graphics.PageManagement.Pages.TestPage;
import com.shopping_cart_app.graphics.PageManagement.Pages.TestPage2;

/**
 * @author mmena2017
 *
 */
public class PageManager {
	
	static List<Page> pages;
	
	public static void init() {
		pages = new ArrayList<Page>();
		
		
		LoadPage(new TestPage());
		LoadPage(new TestPage2());
		
	}

	/**
	 * 
	 */
	private static void LoadPage(Page p) {
		System.out.println("Loading Page " + p.getClass() + ". Assigning to pageIndex:" + pages.size() );
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
