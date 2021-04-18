package com.aarya.javapractice;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashset {
    public static void main(String args[]) {
        HashSet<Pair> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            Pair nextPair = new Pair(a, b);
            set.add(nextPair);
            System.out.println(set.size());
            // System.out.println(set.toString());
        }
        sc.close();
    }

    static class Pair {
        String a, b;

        public Pair(String x, String y) {
            a = x;
            b = y;
        }

        @Override
        public int hashCode() {
            return a.hashCode() + b.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair p = (Pair) o;
            if (this.a.equals(p.a) && this.b.equals(p.b)) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return String.format("[%s, %s]", a, b);
        }
    }
}
