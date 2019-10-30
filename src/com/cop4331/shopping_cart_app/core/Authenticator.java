/**
 * 
 */
package com.cop4331.shopping_cart_app.core;

/**
 * @author mmena2017
 *
 */
public class Authenticator {
	public static boolean Auth(String user, String pass) {
		String accountPass = "test";
		
		if(pass.equals(accountPass)) {
			return true;
		}
		return false;
	}
}
