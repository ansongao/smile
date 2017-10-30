package com.baidu.utilOne;

public class IncDecThread {
	private int j = 10;

	
	public static void main(String[] args) {
		IncDecThread incDec = new IncDecThread();
		Inc inc = incDec.new Inc();
		Dec dec = incDec.new Dec();
		for (int i = 0; i < 2; i++) {
			Thread thread = new Thread(inc);
			thread.start();
			thread = new Thread(dec);
			thread.start();
		}
	}

	public synchronized void inc() {
		j++;
		System.out.println(Thread.currentThread().getName() + "-inc:" + j);
	}

	public synchronized void dec() {
		j--;
		System.out.println(Thread.currentThread().getName() + "-dec:" + j);
	}

	class Inc implements Runnable {
		public void run() {
			for (int i = 0; i < 20; i++) {
				inc();
			}
		}
	}

	class Dec implements Runnable {
		public void run() {
			for (int i = 0; i < 20; i++) {
				dec();
			}
		}
	}
}