package com.dev118.jexample.basic.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SimpleThread2 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
			System.out.println(Thread.currentThread().getName() + "#" + i);
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		FutureTask<Integer> ft = new FutureTask<Integer>(new SimpleThread2());
		FutureTask<Integer> ft1 = new FutureTask<Integer>(new SimpleThread2());
		new Thread(ft).start();
		new Thread(ft1).start();
		System.out.println(ft.get());
		System.out.println(ft1.get());
	}

}
