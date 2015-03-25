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

	private List<BookEntity> bookList = new ArrayList<BookEntity>();

	@PostConstruct
	@Override
	public void init() {
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
		int index = getIndexByBookId(id);
		if (index != -1) {
			bookList.remove(index);
		}
	}

	@Override
	public void update(BookEntity bookEntity) {
		int index = getIndexByBookId(bookEntity.getId());
		if (index != -1) {
			BookEntity bookEntityOld = bookList.get(index);
			
			bookEntityOld.setName(bookEntity.getName());
			bookEntityOld.setAuthor(bookEntity.getAuthor());
			bookEntityOld.setDescription(bookEntity.getDescription());
		}
	}

	@Override
	public BookEntity findOne(Integer id) {
		BookEntity bookEntity = null;
		int index = getIndexByBookId(id);
		if (index != -1) {
			bookEntity = bookList.get(index);
		}
		return bookEntity;
	}

	@Override
	public List<BookEntity> findAll() {
		System.out.println("BookSize:" + bookList.size());
		return bookList;
	}
	
	

	private Integer getIndexByBookId(Integer id) {
		int index = -1;
		for (int i = 0; i < bookList.size(); i++) {
			BookEntity bookEntity = bookList.get(i);
			if (bookEntity.getId() == id) {
				index = i;
				break;
			}
		}
		return index;
	}

}
