package com.dev118.jexample.basic.annotation;

public interface Ioc {

	public Object getBean(String id);

	public void setBean(String id, Object obj);

	public Integer getCount();

	public void printList();

}
