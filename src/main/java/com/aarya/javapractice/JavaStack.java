package com.aarya.javapractice;

import java.util.*;

public class JavaStack {
    public static void main(String args[]) {
        new JavaStack();
    }

    public static enum BracketType {
        open, close
    };

    public static enum BracketShape {
        para, curl, square
    }

    public JavaStack() {
        start();
    }

    public static boolean isBalanced(String s) {
        Stack<Bracket> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            Bracket bracket = BracketFactory.create(c);
            if (bracket == null) {
                continue;
            }
            if (bracket.type == BracketType.close) {
                if (stack.isEmpty())
                    return false;
                if (!stack.peek().isPair(bracket))
                    return false;
                else
                    stack.pop();
            } else {
                stack.push(bracket);
            }
        }
        // all brackets are balanced if stack is empty
        return stack.isEmpty() ? true : false;
    }

    // program to check brackets are balanced
    public static void start() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(isBalanced(s));
        }
        sc.close();
    }

    static class Bracket implements Pairable {

        BracketType type;
        BracketShape shape;

        Bracket(BracketType t, BracketShape s) {
            this.type = t;
            this.shape = s;
        }

        public boolean isPair(Bracket other) {
            if (this.type != other.type && this.shape == other.shape) {
                return true;
            }
            return false;
        }
    }

    static class BracketFactory {

        public static Bracket create(char b) {
            BracketType type = null;
            BracketShape shape = null;

            if (b == '(' || b == '{' || b == '[') {
                type = BracketType.open;
                if (b == '(') {
                    shape = BracketShape.para;
                }
                if (b == '{') {
                    shape = BracketShape.curl;
                }
                if (b == '[') {
                    shape = BracketShape.square;
                }
            }

            if (b == ')' || b == '}' || b == ']') {
                type = BracketType.close;
                if (b == ')') {
                    shape = BracketShape.para;
                }
                if (b == '}') {
                    shape = BracketShape.curl;
                }
                if (b == ']') {
                    shape = BracketShape.square;
                }
            }

            if (type != null) {
                return new Bracket(type, shape);
            }
            return null;
        }

    }

    static interface Pairable {
        public boolean isPair(Bracket other);
    }
}
