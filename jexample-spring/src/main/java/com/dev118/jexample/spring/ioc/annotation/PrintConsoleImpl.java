package com.dev118.jexample.spring.ioc.annotation;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.dev118.jexample.spring.ioc.Print;

@Component
public class PrintConsoleImpl implements Print {

	@PostConstruct
	@Override
	public void init() {
		System.out.println("PrintConsoleImpl.init()...");
	}

	@Override
	public void show(String str) {
		System.out.println("PrintConsoleImpl.show(" + str + ")...");
	}

}
