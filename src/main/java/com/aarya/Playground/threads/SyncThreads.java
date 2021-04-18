package com.aarya.Playground.threads;

public class SyncThreads {
	
	public static void main(String args[]) {
		Sequence sequence = new Sequence();
		Worker w1 = new Worker(sequence, "one");
		Worker w2 = new Worker(sequence, "two");
		System.out.println("thread one is alive: " + w1.thread.isAlive());
		System.out.println("thread two is alive: " + w2.thread.isAlive());
		try {
			System.out.println("Waiting for threads to finish.");
			w1.thread.join();
			w2.thread.join();
		}
		catch(InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		
		System.out.println("thread one is alive: " + w1.thread.isAlive());
		System.out.println("thread two is alive: " + w2.thread.isAlive());
		
		System.out.println("Main thread exiting");
	}
}

class Sequence {
	
	int current;
	
	Sequence(){
		current = 1;
	}
	
	synchronized int next() {
		current = current + 3;
		return current;
	}
}

class Worker implements Runnable {
	String name;
	Thread thread;
	Sequence sequence;
	
	Worker(Sequence s, String n){
		sequence = s;
		name = n;
		thread = new Thread(this, name);
		System.out.println("Thread: " + thread);
		thread.start();
	}
	
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				System.out.printf("%s: %d\n", name, sequence.next());
				Thread.sleep(100);
			}
		}
		catch (InterruptedException e) {
			System.err.println(name + " was interrupted");
		}
		System.out.println(name + " done");
	}
}
