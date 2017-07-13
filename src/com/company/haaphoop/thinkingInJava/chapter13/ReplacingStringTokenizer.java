package com.company.haaphoop.thinkingInJava.chapter13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/13 21:30
 * @Modified:
 */
public class ReplacingStringTokenizer {
    public static void main(String[] args) {
        String input = "But I'm not dead yet! I feel happy!";
        StringTokenizer stoke = new StringTokenizer(input);
        while (stoke.hasMoreElements()) {
            System.out.print(stoke.nextToken() + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(input.split(" ")));
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
    }
}
