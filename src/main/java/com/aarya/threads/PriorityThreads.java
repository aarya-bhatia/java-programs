package com.aarya.threads;

public class PriorityThreads {

	public static void main(String args[]) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi  = new Clicker(Thread.NORM_PRIORITY + 2);
		Clicker lo = new Clicker(Thread.NORM_PRIORITY - 2);
		
		lo.start();
		hi.start();
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
		
		lo.stop();
		hi.stop();
		
		try {
			lo.t.join();
			hi.t.join();
		} catch(InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		System.out.println("Low-priority thread: " + lo.click);
		System.out.println("High-priority thread: " + hi.click);
	}
}

