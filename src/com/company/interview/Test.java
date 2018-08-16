package com.company.interview;

public class Test {
    public static void main(String[] args) {
        int i=10;
        if (i++ == 11 && i++ == 12) {
            System.out.println(i);
        }
        System.out.println("i= "+ i);

        int n =10;
        if (n++ == 11 & n++== 12){
            System.out.println(n);
        }
        System.out.println("n= "+ n);
    }
}
