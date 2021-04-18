package com.aarya.javapractice;

import java.util.*;

public class JavaMap implements Runnable {

    protected Thread t = new Thread(this);
    private HashMap<String, Long> map = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public JavaMap() {
        t.start();
    }

    public void run() {
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            long number = sc.nextLong();
            sc.nextLine();
            System.out.println(name + " -> " + number);
            map.put(name, number);
        }

        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            System.out.println("Looking up: " + name);
            if (map.containsKey(name)) {
                System.out.println(name + "=" + map.get(name));
            } else {
                System.out.println("Not found");
            }
        }
    }

    public static void main(String args[]) {
        JavaMap j = new JavaMap();
        try {
            j.t.join();
        } catch (Exception ex) {
        }
    }
}
