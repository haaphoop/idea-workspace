package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 22:26
 * @Modified:
 */
public class SortedSetInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        SortedSet<Integer> integers = new TreeSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            integers.add(random.nextInt(30));
        }
        System.out.println(integers);
    }
}
