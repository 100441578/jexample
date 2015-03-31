package com.dev118.jexample.basic.copy;

public class ArrayCopyTest {

	public static void main(String[] args) {
		int[] intArray = { 0, 1, 2, 3 };
		// 深拷贝
		int[] intAArray = intArray.clone();
		intAArray[0] = 9;
		printArrayOfInt(intArray);

		// 浅拷贝
		int[] intBArray = intArray;
		intBArray[0] = 9;
		printArrayOfInt(intArray);
	}

	public static void printArrayOfInt(int[] array) {
		for (int item : array) {
			System.out.println(item);
		}
		System.out.println("===============Over");
	}

}
