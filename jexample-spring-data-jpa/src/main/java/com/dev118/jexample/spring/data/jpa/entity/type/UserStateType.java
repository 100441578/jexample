package com.dev118.jexample.spring.data.jpa.entity.type;

public enum UserStateType {

	DISABLE("禁用"), ENABLE("可用");

	private String name;

	UserStateType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
