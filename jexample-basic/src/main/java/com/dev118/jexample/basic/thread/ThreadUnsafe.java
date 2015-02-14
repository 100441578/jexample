package com.dev118.jexample.basic.thread;

public class ThreadUnsafe implements Runnable {

	private int sum;

	private Integer sum1 = 0;

	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	@Override
	public void run() {

		threadLocal.set(0);

		for (int i = 0; i < 10; i++) {
			sum += i;
			sum1 += i;
			threadLocal.set(threadLocal.get() + i);
		}
		//
		System.out.println(Thread.currentThread().getName() + "#int#" + sum);
		System.out.println(Thread.currentThread().getName() + "#Integer#" + sum1);
		System.out.println(Thread.currentThread().getName() + "#ThreadLocal#" + threadLocal.get());
	}

	public static void main(String[] args) {
		ThreadUnsafe target = new ThreadUnsafe();
		for (int i = 0; i < 10; i++) {
			new Thread(target).start();
		}
	}

}
