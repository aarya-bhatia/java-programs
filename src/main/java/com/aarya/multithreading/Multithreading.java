package com.aarya.multithreading;

public class Multithreading {

	public static void main(String args[]) {
		Buffer b = new Buffer();
		new Thread(new Producer(b)).start();
		new Thread(new Consumer(b)).start();
	}

}

class Buffer {
	int a;
	boolean produced = false;

	public synchronized  void produce(int x) {
		if(produced) {
			System.out.println("producer is waiting...");
			try{ wait(); } catch(Exception e) { e.printStackTrace(); }
		}
		a=x;
		System.out.printf("product %d is produced.\n", a);
		produced = !produced;
		notify();
	}

	public synchronized void consume(int x) {
		if(!produced) {
			System.out.println("consumer is waiting...");
			try{ wait(); } catch(Exception e) { e.printStackTrace(); }
		}
		a=x;
		System.out.printf("product %d is consumed.\n", a);
		produced = !produced;
		notify();
	}
}

class Producer implements Runnable {
	
	Buffer b;

	public Producer(Buffer bf) {
		b = bf;
	}

	public void run() {
		System.out.println("producer starting");
		for(int i = 0; i <= 10; i++){
			b.produce(i);
		}
	}
}

class Consumer implements Runnable {
	
	Buffer b;

	public Consumer(Buffer bf) {
		b=bf;
	}

	public void run() {
		System.out.println("consmer starting");
		for(int i = 0; i <= 10; i++){
			b.consume(i);
		}
	}
}
