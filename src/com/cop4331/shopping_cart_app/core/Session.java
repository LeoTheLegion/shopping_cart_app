package com.cop4331.shopping_cart_app.core;

import java.util.HashMap;

public class Session {
	static HashMap<String,Object> cookies;

	public static void createNewSession() {
		cookies = new HashMap<String,Object>();
	}
	
	public static void createCookie(String cookieName, Object object) {
		System.out.println("Creating Cookie: ("+ cookieName+ "|-|" + object.getClass()+")");
		cookies.put(cookieName, object);
	}
	
	public static Object getCookie(String cookieName) {
		Object obj = cookies.get(cookieName);
		if(obj == null)
			System.err.println("WARNING: The cookie("+cookieName +") was not found...");
		return obj;
	}
}
