package com.aarya.Playground.threads;

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

class Clicker implements Runnable {
	int click = 0;
	Thread t;
	private volatile boolean running;
	
	public Clicker(int p) {
		t = new Thread(this);
		t.setPriority(p);
		System.out.println("New thread: " + t);
		running = true;
	}
	
	public void run() {
		while(running) {
			click++;
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
	
	public void start() {
		t.start();
	}
	
	public void stop() {
		running = false;
	}
}