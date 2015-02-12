package com.dev118.jexample.basic.reflex;

public class SimpleBean {

	private String username;

	private String password;

	private Integer sex;

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
