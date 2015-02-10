package com.dev118.jexample.spring.ioc.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dev118.jexample.spring.ioc.Print;

public class IocBeansConfigTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(BeansConfig.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		System.out.println(context.getId());
	}

	@Test
	public void testShow() {
		Print print = context.getBean(Print.class);
		print.show("hello");
	}

}
