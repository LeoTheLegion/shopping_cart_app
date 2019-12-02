package com.cop4331.shopping_cart_app.filemanager;

import java.util.ArrayList;

public interface ILoad<E> {
	ArrayList<E> load(String fileName);
}
