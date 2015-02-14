package com.dev118.jexample.basic.thread;

public class SimpleThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "#" + i);
		}
	}

	public static void main(String[] args) {
		new SimpleThread().start();
		new SimpleThread().start();
	}

}
