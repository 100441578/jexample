package com.dev118.jexample.basic.annotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IocAnn implements Ioc {

	private Map<String, Object> beans = new HashMap<String, Object>();

	public IocAnn(Class<?> annotatedClass) {
		// Class<?> myConfig = annotatedClass;
		Config config = annotatedClass.getAnnotation(Config.class);

		String basePackage = config.basePackage();

		System.out.println(basePackage);

	}

	public IocAnn(String basePackage) {
		// Package scanPackage = Package.getPackage(basePackage);

	}

	@Override
	public Object getBean(String id) {
		return beans.get(id);
	}

	@Override
	public void setBean(String id, Object obj) {
		beans.put(id, obj);
	}

	@Override
	public Integer getCount() {
		return beans.size();
	}

	@Override
	public void printList() {
		System.out.println("----------------------------------------");
		for (Entry<String, Object> entry : beans.entrySet()) {
			System.out.println(entry.getKey() + "#" + entry.getValue().getClass().getName());
		}
		System.out.println("----------------------------------------");
	}

	// private void scanPackage() {
	//
	// }
	//
	// private void scanClass() {
	//
	// }
	//
	// private void scanField() {
	//
	// }

}
