package com.dev118.jexample.spring.ioc;

import org.springframework.beans.factory.FactoryBean;

import com.dev118.jexample.spring.bean.BookEntity;

public class BookEntityFactoryBean implements FactoryBean<BookEntity> {

	@Override
	public BookEntity getObject() throws Exception {
		return new BookEntity(0, "Java编程思想", "外国人", "每个Java程序员都应该读的一本书");
	}

	@Override
	public Class<?> getObjectType() {
		return BookEntity.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
