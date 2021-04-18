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
		return switch (name) {
			case "A" -> countA;
			case "B" -> countB;
			default -> 0;
		};
	}
}

