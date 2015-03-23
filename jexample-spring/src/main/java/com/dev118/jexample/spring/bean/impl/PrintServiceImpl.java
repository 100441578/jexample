package com.dev118.jexample.spring.bean.impl;

import org.springframework.stereotype.Service;

import com.dev118.jexample.spring.bean.api.PrintService;

/**
 * 
 * @author Wen
 *
 */
@Service
public class PrintServiceImpl implements PrintService {

	private static final String STRING_COLON = ":";

	@Override
	public void print() {
		System.out.println(HELLO);
	}

	@Override
	public void print(String name) {
		System.out.println(HELLO + STRING_COLON + name);

	}

	@Override
	public String format(String name) {
		return "【" + name + "】";
	}

}
