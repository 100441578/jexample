package com.dev118.jexample.basic.copy;

public class ClassCopyTest {

	public static void main(String[] args) {
		BeanOfCopy bean = new BeanOfCopy(1, "one");
		System.out.println(bean);

		BeanOfCopy bean0 = bean;
		bean0.setCode("ten");
		System.out.println(bean0);
	}
}
