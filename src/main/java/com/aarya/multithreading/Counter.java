package com.aarya.multithreading;

class Counter implements Runnable {

	long startTime;
	boolean paused = true;
	float limit;

	public Counter(int l) {
		startTime = System.currentTimeMillis();
		paused = false;
		limit = l;
		System.out.println(Thread.currentThread().getName() + " has begun");
	}

	public float timeElapsed() {
		long dt =  System.currentTimeMillis() - startTime;
		return (float)(dt/1000); // time in seconds
	}

	@Override
	public void run() {
		String s = "Timer value: ";
		float time = 0L;
		while(!paused) {
			time = timeElapsed();
			if(time >= limit) {
				stop();
			}
			System.out.println(s + String.valueOf(time));
			try {
				Thread.sleep(100);
			} catch(InterruptedException ex){} 
		}
	}

	public void stop() {
		paused = true;
	}

	public void start() {
		paused = false;
	}
}
