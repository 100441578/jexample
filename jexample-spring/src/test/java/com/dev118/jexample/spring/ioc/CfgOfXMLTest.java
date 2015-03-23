package com.dev118.jexample.spring.ioc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dev118.jexample.spring.bean.api.BookService;
import com.dev118.jexample.spring.bean.api.PrintService;

public class CfgOfXMLTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring-ioc-config-xml.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test0() {
		PrintService ps = context.getBean(PrintService.class);
		Assert.assertNotNull(ps);
	}

	@Test
	public void test1() {
		BookService bs = context.getBean(BookService.class);
		Assert.assertNotNull(bs);
		Assert.assertNotNull(bs.findAll());
		System.out.println(bs.findAll().size());
	}

}
