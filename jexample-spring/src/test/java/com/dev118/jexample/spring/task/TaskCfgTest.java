package com.dev118.jexample.spring.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskCfgTest {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-quartz-config.xml");
		System.out.println(context.getId());
	}

}
