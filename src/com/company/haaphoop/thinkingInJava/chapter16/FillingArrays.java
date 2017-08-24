package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.Arrays;

/*
* 使用Arrays.fill()可以填充整个数组，或者像最后一条语句所示，只填充数组的某个区域。但是由于只能用单一的数值来调用
* Arrays.fill()，因此所产生的结果并非特别有用。
* */
public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        short[] a4 = new short[size];
        int[] a5 = new int[size];
        long[] a6 = new long[size];
        float[] a7 = new float[size];
        double[] a8 = new double[size];
        String[] a9 = new String[size];
        Arrays.fill(a1, true);
        System.out.println("a1 = " + Arrays.toString(a1));
        Arrays.fill(a2, (byte)11);
        System.out.println("a2 = " + Arrays.toString(a2));
        Arrays.fill(a3, 'x');
        System.out.println("a3 = " + Arrays.toString(a3));
        Arrays.fill(a4, (short)17);
        System.out.println("a4 = " + Arrays.toString(a4));
        Arrays.fill(a5, 19);
        System.out.println("a5 = " + Arrays.toString(a5));
        Arrays.fill(a9, "Hello");
        System.out.println("a9 = " + Arrays.toString(a9));
        Arrays.fill(a9, 3, 5, "world");
        System.out.println("a9 = " + Arrays.toString(a9));
    }
}
