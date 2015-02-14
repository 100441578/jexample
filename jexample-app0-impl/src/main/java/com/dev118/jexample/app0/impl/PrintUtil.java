package com.dev118.jexample.app0.impl;

public final class PrintUtil {

	private PrintUtil() {
	}

	public static void print(String type, String content) {
		System.out.println("APP1#" + type + "#" + content);
	}

	public static String format(String type, String content) {
		return "a\nb\nc";
	}

	public static void main(String[] args) {
		System.out.println(PrintUtil.format(null, null));

	}

}
