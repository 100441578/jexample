package com.dev118.jexample.spring.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:task-config.xml" })
public class SpringTaskTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private SpringTask task;

	@Test
	public void test() {
		System.out.println(task);
	}

}
