package com.company.haaphoop.thinkingInJava.chapter15;

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Automible> h3 = new Holder3<Automible>(new Automible());
        Automible automible = h3.getA();
        //h3.setA("999");
    }
}

class Automible{}