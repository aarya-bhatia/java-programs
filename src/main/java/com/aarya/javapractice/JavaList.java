package com.aarya.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

    List<Integer> data = new ArrayList<>();

    public void insertAtIndex(int valToPut, int placeToPut) {
        data.add(placeToPut, Integer.valueOf(valToPut));
    }

    public void delAtIndex(int indexToDel) {
        data.remove(indexToDel);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(sc.next());
            data.add(num);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String operation = sc.next();
            if (operation.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                insertAtIndex(y, x);
            }
            if (operation.equals("Delete")) {
                int x = sc.nextInt();
                delAtIndex(x);
            }
        }
        sc.close();
        for (int i = 0; i < data.size(); i++) {
            String res = String.valueOf(data.get(i));
            System.out.print(res);
            if (i < data.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String args[]) {
        new JavaList().start();
    }
}