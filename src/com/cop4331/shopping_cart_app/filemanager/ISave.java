package com.cop4331.shopping_cart_app.filemanager;

import java.util.ArrayList;

public interface ISave<E> {
	/**
	 * @param fileName
	 * @param items
	 */
	void save(String fileName,ArrayList<E> items);
}
