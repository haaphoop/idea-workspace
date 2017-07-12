package com.company.haaphoop.thinkingInJava.chapter13;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/12 22:46
 * @Modified:
 */
public class SimpleFormat {
    /*
    * 可以看到format()与printf()是等价的，它们只需要一个简单的格式化字符串，加上一串参数即可，每个参数对应一个格式修饰符。
    * */
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        System.out.println("ROw 1: [" + x + " " + y + "]");
        System.out.format("Row 1: [%d %f]\n", x, y);
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}
