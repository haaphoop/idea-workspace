package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/6 21:18
 * @Modified:
 */
public class GenericsAndUpcasting {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple apple : apples) {
            System.out.println(apple);
        }
    }
}

class GrannySmith extends Apple {
    @Override
    public String toString() {
        return "GrannySmith";
    }
}

class Gala extends Apple {}

class Fuji extends Apple {}

class Braeburn extends Apple {}