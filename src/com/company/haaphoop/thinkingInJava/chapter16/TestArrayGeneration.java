package com.company.haaphoop.thinkingInJava.chapter16;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;

public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConverTo.primitive(Generated.array(Boolean.class, new
                CountingGenerator.Boolean(), size));
        System.out.println("a1 = " + Arrays.toString(a1));

        byte[] a2 = ConverTo.primitive(Generated.array(Byte.class, new
                CountingGenerator.Byte(), size));
        System.out.println("a2 = " + Arrays.toString(a2));

        char[] a3 = ConverTo.primitive(Generated.array(Character.class, new
                CountingGenerator.Character(), size));
        System.out.println("a3 = " + Arrays.toString(a3));


    }
}
