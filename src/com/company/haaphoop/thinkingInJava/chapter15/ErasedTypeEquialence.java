package com.company.haaphoop.thinkingInJava.chapter15;

import java.util.ArrayList;

public class ErasedTypeEquialence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
