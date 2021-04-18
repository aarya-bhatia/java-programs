package com.aarya.strings;

public class PalindromeSubstrings {

    static class Node {
        char val;
        int freq;
        Node prev;
        Node next;

        public Node(char _val, int _freq, Node _prev, Node _next) {
            val = _val;
            freq = _freq;
            prev = _prev;
            next = _next;
        }
    }

    static class LetterFreqList {

        Node head, tail;

        public LetterFreqList() {
            head = new Node('0', 0, null, null);
            tail = new Node('0', 0, null, null);

            head.next = tail;
            tail.prev = head;
        }

        public void add(Node e) {
            /** head <--> ... <--> last <--> e <--> tail */
            Node last = tail.prev;
            last.next = e;
            e.prev = last;
            e.next = tail;
            tail.prev = e;
        }

        public void add(char letter, int freq) {
            Node e = new Node(letter, freq, null, null);
            add(e);
        }
    }

    public static long substrCount(int n, String s) {
        LetterFreqList list = new LetterFreqList();
        long count = 0;
        char tmp = s.charAt(0);
        int f = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (tmp == c) {
                f++;
            } else {
                list.add(tmp, f);
                System.out.println("added " + tmp + " -> " + f);
                tmp = c;
                f = 1;
            }
        }

        // last element is left
        list.add(tmp, f);
        System.out.println("added " + tmp + " -> " + f);

        for (Node ptr = list.head.next; ptr != list.tail; ptr = ptr.next) {
            System.out.printf("%c,%d\t", ptr.val, ptr.freq);
        }
        System.out.println();

        for (Node ptr = list.head.next; ptr != list.tail; ptr = ptr.next) {
            /** aa..a => # palindrom = 1 + 2 + ... + n, n = # of a's => #p = n(n+1)/2 */
            count += ptr.freq * (ptr.freq + 1) / 2; // Type 1 Palindrome

            /** aa..a b aa..a => # palindrome = min(# a's on left, # a's on right) */
            if (ptr.freq == 1 && ptr.prev != list.head && ptr.next != list.tail && ptr.prev.val == ptr.next.val) {
                System.out.printf("Left=%c, Right=%c \n", ptr.prev.val, ptr.next.val);
                count += Math.min(ptr.prev.freq, ptr.next.freq); // Type 2 Palindrome
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // compute("aaaabaabbaa");
        compute("mnonopoo"); // expect = 12
    }

    public static void compute(String s) {
        long count = substrCount(s.length(), s);
        System.out.println(count);
    }
}