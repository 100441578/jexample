package com.dev118.jexample.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev118.jexample.spring.bean.api.BookService;
import com.dev118.jexample.spring.bean.api.PrintService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-ioc-config-annotation.xml" })
public class SprintJunitTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private PrintService ps;

	@Autowired
	private BookService bs;

	@Test
	public void test0() {
		Assert.assertNotNull(ps);
	}

	@Test
	public void test1() {
		Assert.assertNotNull(bs);
	}

}
