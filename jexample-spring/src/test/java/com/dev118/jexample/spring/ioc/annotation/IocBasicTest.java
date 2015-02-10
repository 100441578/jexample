package com.dev118.jexample.spring.ioc.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dev118.jexample.spring.ioc.Print;

public class IocBasicTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("ioc-config-basic.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Print print = context.getBean(Print.class);
		print.show("hello");

		Print print2 = (Print) context.getBean("printImpl");
		print2.show("你好");
	}

}
