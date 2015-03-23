package com.dev118.jexample.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev118.jexample.spring.bean.api.BookService;
import com.dev118.jexample.spring.bean.api.PrintService;
import com.dev118.jexample.spring.bean.impl.BookServiceImpl;
import com.dev118.jexample.spring.bean.impl.PrintServiceImpl;

@Configuration
public class BeansConfig {

	public @Bean PrintService printService() {
		return new PrintServiceImpl();
	}

	public @Bean(initMethod = "init") BookService bookService() {
		return new BookServiceImpl();
	}

}
