package com.aarya.multithreading;

public class Main {

	public static void main(String args[]) throws InterruptedException {
		Counter c = new Counter(5);
		Thread t = new Thread(c);
		t.start();
		System.out.println(Thread.currentThread().getName() + " has finished.");
	}
}	
