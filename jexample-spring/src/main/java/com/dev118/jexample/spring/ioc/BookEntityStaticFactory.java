package com.dev118.jexample.spring.ioc;

import java.util.HashMap;
import java.util.Map;

import com.dev118.jexample.spring.bean.BookEntity;

public class BookEntityStaticFactory {

	private static Map<Integer, BookEntity> books = new HashMap<Integer, BookEntity>();

	static {
		books.put(0, new BookEntity(0, "Java编程思想", "外国人", "每个Java程序员都应该读的一本书"));
		books.put(1, new BookEntity(1, "Effective Java", "也是老外写的", "很实用"));
	}

	public static BookEntity get(Integer id) {
		return books.get(id);
	}
}
