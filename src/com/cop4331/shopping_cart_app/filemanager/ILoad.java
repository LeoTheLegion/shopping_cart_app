package com.cop4331.shopping_cart_app.filemanager;

import java.util.ArrayList;

public interface ILoad<E> {
	/**
	 * @param fileName
	 * @return
	 */
	ArrayList<E> load(String fileName);
}
