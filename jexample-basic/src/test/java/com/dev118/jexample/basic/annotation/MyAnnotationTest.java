package com.dev118.jexample.basic.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyAnnotationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// Ioc ioc = new IocAnn(MyConfig.class);
		Ioc ioc = new IocAnn("com.dev118.jexample.basic.annotation.sample");

		System.out.println(ioc.getCount());
	}
}
