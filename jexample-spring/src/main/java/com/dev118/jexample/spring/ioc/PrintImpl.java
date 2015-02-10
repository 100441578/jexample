package com.dev118.jexample.spring.ioc;

public class PrintImpl implements Print {

	@Override
	public void init() {
		System.out.println("PrintImpl.init()...");

	}

	@Override
	public void show(String str) {
		System.out.println("PrintImpl.show(" + str + ")...");
	}

}
