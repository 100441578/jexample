package com.dev118.jexample.basic.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListVSVectorTest implements Runnable {

	private List<Integer> list = new ArrayList<Integer>(200);

	private Vector<Integer> vector = new Vector<Integer>();

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			list.add(i);
			vector.add(i);
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("list size:" + list.size());
		System.out.println("vector size:" + vector.size());
	}

	public static void main(String[] args) {
		Runnable vs = new ListVSVectorTest();
		for (int i = 0; i < 20; i++) {
			new Thread(vs, "线程" + i).start();
		}
	}

}
