package com.aarya.threads;

class WaitNotifyExample {
	public static void main(String args[]) {
		Q q = new Q();
		Producer producer = new Producer(q);
		Consumer consumer = new Consumer(q);
		try {
			producer.start();
			consumer.start();
			Thread.sleep(1000);
			producer.stop();
			consumer.stop();
		}
		catch(InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
		
		try {
			producer.t.join();
			consumer.t.join();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted Exception caught");
		}
		
		System.out.println("Main thead exiting");
	}
}

class Q {
	int n;
	boolean valueSet = false;
	
	synchronized int get() {
		if(!valueSet) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Got : " + n);
		valueSet = false;
		notify();
		return n;
	}
	
	synchronized void put(int n) {
		if(valueSet) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.n = n;
		valueSet = true;
		System.out.println("Put : " + n);
		notify();
	}
}

class Producer implements Runnable {
	Q q;
	Thread t;
	private volatile boolean running = true;
	
	Producer(Q q){
		this.q = q;
		t = new Thread(this, "Producer");
		System.out.println(t);
	}
	
	public void run() {
		int i = 0;
		
		while(running) {
			q.put(i++);
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {}
		}
	}
	
	public void start() {
		t.start();
	}
	
	public void stop() {
		running = false;
	}
}

class Consumer implements Runnable {
	Q q;
	Thread t;
	private volatile boolean running = true;
	
	Consumer(Q q){
		this.q = q;
		t = new Thread(this, "consumer");
		System.out.println(t);
	}
	
	public void run() {
		while(running) {
			q.get();
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {}
		}
	}
	
	public void start() {
		t.start();
	}
	
	public void stop() {
		running = false;
	}
}