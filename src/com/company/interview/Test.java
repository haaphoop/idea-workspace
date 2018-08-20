package com.company.interview;

public class Test {
    public static void main(String[] args) {
        String str = "ddd";
        String str1 = new String("ddd").intern();
        System.out.println(str == str1);
    }
}
