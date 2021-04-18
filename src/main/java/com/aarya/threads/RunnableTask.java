package com.aarya.threads;

public class RunnableTask implements Runnable {

    String name;

    RunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        System.out.printf("thread %s", Thread.currentThread().getName());
    }

}
