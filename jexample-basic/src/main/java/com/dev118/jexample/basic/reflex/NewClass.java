package com.dev118.jexample.basic.reflex;

import java.lang.reflect.Constructor;

public class NewClass {

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("com.dev118.jexample.basic.reflex.NewClass");

		NewClass newClass = (NewClass) clazz.newInstance();

		// 通过构造方法创建
		Constructor<?> cons[] = clazz.getConstructors();
		NewClass newClass2 = (NewClass) cons[1].newInstance("admin", "123456", 1);

		System.out.println(newClass);

		System.out.println(newClass2);
	}

	private String username;

	private String password;

	private Integer sex;

	public NewClass() {
		super();
	}

	public NewClass(String username, String password, Integer sex) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

	public String getInfo() {
		return "";
	}

	public void showInfo() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "SimpleBean [username=" + username + ", password=" + password + ", sex=" + sex + "]";
	}

}
