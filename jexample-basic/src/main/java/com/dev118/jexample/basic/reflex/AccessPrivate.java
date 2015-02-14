package com.dev118.jexample.basic.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class AccessPrivate {

	private String name;

	private String age;

	public AccessPrivate() {
		age = String.valueOf(new Random().nextInt(80));
	}

	@SuppressWarnings("unused")
	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccessPrivate [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) throws Exception {
		AccessPrivate ap = new AccessPrivate();
		System.out.println(ap);
		Class<AccessPrivate> clazz = AccessPrivate.class;
		// 私有方法
		Method method = clazz.getDeclaredMethod("setName", String.class);
		method.setAccessible(true);
		method.invoke(ap, "张三");

		System.out.println(ap);
		// 私有属性
		Field field = clazz.getDeclaredField("age");
		field.setAccessible(true);
		field.set(ap, "108");
		System.out.println(ap);

		System.out.println(field.get(ap));

	}
}
