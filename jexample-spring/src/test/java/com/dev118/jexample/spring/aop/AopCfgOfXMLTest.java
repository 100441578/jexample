package com.dev118.jexample.spring.aop;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dev118.jexample.spring.bean.BookEntity;
import com.dev118.jexample.spring.bean.api.BookService;

public class AopCfgOfXMLTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring-aop-config.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BookService bs = context.getBean(BookService.class);
		Assert.assertNotNull(bs);
		List<BookEntity> list = bs.findAll();
		Assert.assertNotNull(list);
		System.out.println(list.size());
	}

}
