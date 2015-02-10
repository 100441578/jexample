package com.dev118.jexample.spring.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev118.jexample.spring.ioc.Print;
import com.dev118.jexample.spring.ioc.PrintImpl;

@Configuration
public class BeansConfig {

	public @Bean(initMethod = "init") Print print() {
		return new PrintImpl();
	}

}
