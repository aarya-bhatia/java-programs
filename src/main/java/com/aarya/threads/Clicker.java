package com.aarya.threads;

public class Clicker implements Runnable {
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
        while (running) {
            click++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
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
