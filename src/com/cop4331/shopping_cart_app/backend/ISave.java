package com.cop4331.shopping_cart_app.backend;

import java.util.ArrayList;

public interface ISave<E> {
	void save(String fileName,ArrayList<E> items);
}