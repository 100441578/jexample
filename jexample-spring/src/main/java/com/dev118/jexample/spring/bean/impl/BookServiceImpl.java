package com.dev118.jexample.spring.bean.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.dev118.jexample.spring.bean.BookEntity;
import com.dev118.jexample.spring.bean.api.BookService;

/**
 * 
 * @author Wen
 *
 */
@Service
public class BookServiceImpl implements BookService {

	private List<BookEntity> bookList;

	@PostConstruct
	@Override
	public void init() {
		bookList = new ArrayList<BookEntity>();

		bookList.add(new BookEntity(1, "C语言编程", "张三", "计算机相关书籍"));
		bookList.add(new BookEntity(2, "C++程序设计", "张三", "计算机相关书籍"));
		bookList.add(new BookEntity(3, "Java编程思想", "张三", "计算机相关书籍"));
		bookList.add(new BookEntity(4, "MongoDB权威指南", "张三", "计算机相关书籍"));

	}

	@Override
	public void add(BookEntity bookEntity) {
		Assert.notNull(bookEntity);
		bookList.add(bookEntity);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BookEntity bookEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public BookEntity findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookEntity> findAll() {
		return bookList;
	}

}
