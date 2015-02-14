package com.dev118.jexample.spring.data.jpa.entity.type;

public enum UserCategoryType {

	SYSTEM("默认用户"), NORMAL("系统创建用户");

	private String desc;

	private UserCategoryType(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
