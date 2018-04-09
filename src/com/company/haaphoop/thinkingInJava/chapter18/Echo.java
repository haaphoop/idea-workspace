package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
    /*
    * 使用异常规范是因为readLine()会抛出IOException。注意，System.in和大多数流一样，通常应该对它进行缓冲。
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System
                .in));
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
