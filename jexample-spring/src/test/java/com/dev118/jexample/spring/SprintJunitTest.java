package com.dev118.jexample.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dev118.jexample.spring.ioc.Print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ioc-config-annotation.xml" })
public class SprintJunitTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private Print print;

	@Test
	public void test() {
		print.show("hello");
	}

}
