package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args) {
        // 重要的是要使用有两个参数的构造器，并将第二个参数设为true，以便开启自动清空功能；否则，可能看不到输出。
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, fdsworld!");
    }
}
