package com.aarya.functions;

public class Add implements Function {

    Function f1;
    Function f2;

    public Add(Function f, Function g) {
        this.f1 = f;
        this.f2 = g;
    }

    public float eval() {
        return f1.eval() + f2.eval();
    }

    public String toString() {
        return f1.toString() + " + " + f2.toString();
    }
}

class Constant implements Function {

    float k;

    public Constant(float a) {
        this.k = a;
    }

    public float eval() {
        return k;
    }

    public String toString() {
        return String.valueOf(k);
    }
}

class Multiply implements Function {

    Function f1;
    Function f2;

    @Override
    public float eval() {
        return 0;
    }
}

interface Brackets {

}

class Parenthesis implements Brackets {
    Function f;

    public Parenthesis(Function f) {
        this.f = f;
    }

    public String toString() {
        return "( " + f.toString() + " )";
    }
}

class Exponent implements Function {

    Function base;
    Function power;

    public Exponent(Function b, Function p) {
        this.base = b;
        this.power = p;
    }

    public float eval() {
        return (float) Math.pow(this.base.eval(), this.power.eval());
    }

    public String toString() {
        return new Parenthesis(base).toString() + " ^ " + new Parenthesis(power).toString();
    }
}

class Variable implements Function {

    char var;

    public Variable(char symbol) {
        this.var = symbol;
    }

    public String toString() {
        return "" + var;
    }

    public float eval() {
        return 0;
    }
}