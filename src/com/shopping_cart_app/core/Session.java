package com.shopping_cart_app.core;

import java.util.HashMap;

public class Session {
	static Session currentSession;
	HashMap<String,Object> cookies;
	
	
	private Session() {
		cookies = new HashMap<String,Object>();
	}

	public static void createNewSession() {
		currentSession = new Session();
	}
	
	public static void createCookie(String cookieName, Object object) {
		System.out.println("Creating Cookie: ("+ cookieName+ "|-|" + object.getClass()+")");
		currentSession.cookies.put(cookieName, object);
	}
	
	public static Object getCookie(String cookieName) {
		Object obj = currentSession.cookies.get(cookieName);
		if(obj == null)
			System.err.println("WARNING: The cookie("+cookieName +") was not found...");
		return obj;
	}
}
