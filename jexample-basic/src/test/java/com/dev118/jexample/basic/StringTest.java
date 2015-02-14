package com.dev118.jexample.basic;

import junit.framework.Assert;

import org.junit.Test;

public class StringTest {
	
	@Test
	public void t() {
		String a = "hello";
		String b = "1";
		System.out.println(a.getBytes());
		System.out.println(b.getBytes());
		
		String a1 = "a";
		String a2 = "a";
		System.out.println(a1.getBytes());
		System.out.println(a2.getBytes());
	}

	@Test
	public void test() {
		String a = "a" + "b" + 1;
		String b = "ab1";
		// 编译优化会把第一行优化成 a = "ab1"
		System.out.println(a == b);
		Assert.assertTrue(a == b);

		String s = "a";
		String s1 = s + "b";
		String s2 = "ab";
		// TODO
		System.out.println(s1 == s2);

	}

	private final static String getA() {
		return "a";
	}

	@Test
	public void test1() {
		String a = "a";
		final String c = "a";

		String b = a + "b";
		String d = c + "b";
		String e = getA() + "b";

		String compare = "ab";
		// false a是变量，有可能会改变，编译时不优化
		System.out.println(b == compare);
		// true c是常量不会改变，所以编译时会优化
		System.out.println(d == compare);
		// false getA()是方法，返回值可能会变化，也不会优化
		System.out.println(e == compare);
	}

	@Test
	public void test2() {
		String a = "a";
		String b = a + "b";
		String c = "ab";
		String d = new String(b);

		// false
		System.out.println(b == c);
		// false
		System.out.println(c == d);
		// true
		System.out.println(c == d.intern());
		// true
		System.out.println(b.intern() == d.intern());
	}

}
