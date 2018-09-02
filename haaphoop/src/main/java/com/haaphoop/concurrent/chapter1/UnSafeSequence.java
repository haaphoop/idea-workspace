package com.haaphoop.concurrent.chapter1;

public class UnSafeSequence {
    private int value;

    public int getValue() {
        return value++;
    }

    public static void main(String[] args) {

    }
}
