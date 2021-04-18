package com.aarya.Playground.functions;

public class Test {

    public static void main(String args[]) {
        Function constant = new Constant(2);
        Function variable = new Variable('x');
        Function add = new Add(constant, variable);
        Function exp = new Exponent(variable, new Constant(3));
        Function add2 = new Add(add, exp);
        System.out.println(add2);
    }

}
