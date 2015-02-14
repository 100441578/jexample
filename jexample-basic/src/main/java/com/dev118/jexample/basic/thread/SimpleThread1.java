package com.dev118.jexample.basic.thread;

public class SimpleThread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "#" + i);
		}
	}

	public static void main(String[] args) {
		SimpleThread1 target = new SimpleThread1();
		new Thread(target, "线程一").start();
		new Thread(target, "线程二").start();
	}

}
