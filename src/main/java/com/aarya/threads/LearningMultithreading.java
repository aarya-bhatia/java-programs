package com.aarya.threads;

public class LearningMultithreading {
	
	private static int countA = 0;
	private static int countB = 0;
	
	public static void main(String args[]) {
		System.out.println("Hello there...");
		LearningMultithreading L = new LearningMultithreading();
		
		int randomIntA = (int)(Math.random()*100);
		int randomIntB = (int)(Math.random() * 100);

		Task t1 = new Task(randomIntA, L);
		t1.setName("A");
		
		Task t2 = new Task(randomIntB, L);
		t2.setName("B");
		
		t1.start();
		t2.start();
		
		RunnableTask runner = new RunnableTask("Aarya");
		Thread thread = new Thread(runner);
		thread.start();
	}
	
	public void update(String name) {
		switch(name) {
			case "A": countA++;
			break;
			case "B": countB++;
			break;
			default: break;
		}
	}
	
	public int getCount(String name) {
		switch(name) {
		case "A": return countA;
		case "B": return countB;
		default: return 0;
		}
	}
}

class Task extends Thread {
	
	int total;
	LearningMultithreading L;
	
	Task(int t, LearningMultithreading L){
		this.total = t;
		this.L = L;
	}
	
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i = 0; i < total; i++) {
			try {
				System.out.printf("Hello from thread %s\n", name);
				L.update(name);
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		System.out.println("Total count for thread " + name + " is " + L.getCount(name));
	}
}

class RunnableTask implements Runnable {

	String name;
	
	RunnableTask(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(this.name);
		System.out.printf("thread %s", Thread.currentThread().getName());
	}
	
}
