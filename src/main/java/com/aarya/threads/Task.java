package com.aarya.threads;

public class Task extends Thread {

    int total;
    LearningMultithreading L;

    Task(int t, LearningMultithreading L) {
        this.total = t;
        this.L = L;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < total; i++) {
            try {
                System.out.printf("Hello from thread %s\n", name);
                L.update(name);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        System.out.println("Total count for thread " + name + " is " + L.getCount(name));
    }
}
