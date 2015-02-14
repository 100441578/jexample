package com.dev118.jexample.basic;

import org.junit.Test;

public class IntegerTest {

	@Test
	public void test() {
		Integer a = 1;
		Integer b = 1;
		Integer c = 128;
		Integer d = 128;
		// -128 ~ 127 直接从缓存里取，所以对象地址也一样，具体可以查看Integer中的valueOf方法实现
		// 缓存大小可以通过JVM启动参数来更改，-Djava.lang.Integer.IntegerCache.high=10000
		System.out.println(a == b);
		// 对比内存地址
		System.out.println(c == d);
		// 自动拆箱
		System.out.println(c.intValue() == 128);
		System.out.println(c == 128);
	}
}
