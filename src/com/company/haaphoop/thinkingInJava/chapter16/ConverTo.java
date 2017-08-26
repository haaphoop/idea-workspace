package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.Arrays;

public class ConverTo {
    /*
    * primitive()方法的每个版本都可以创建适当的具有恰当长度的基本类型数组，然后向其中复制包装器类型数组in
    * 中的元素。注意，在下面的表达式中会自动拆包。
    * */

    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator
                .Integer(), 15);
        int[] b = ConverTo.primitive(a);
        System.out.println(Arrays.toString(b));
        boolean[] c = ConverTo.primitive(Generated.array(Boolean.class, new
                CountingGenerator.Boolean(), 7));
        System.out.println(Arrays.toString(c));
    }
    public static boolean[] primitive(Boolean[] in) {
        boolean[] result = new boolean[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }

    public static char[] primitive(Character[] in) {
        char[] result = new char[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }

    public static byte[] primitive(Byte[] in) {
        byte[] result = new byte[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }

    public static short[] primitive(Short[] in) {
        short[] result = new short[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }

    public static int[] primitive(Integer[] in) {
        int[] result = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }

    public static long[] primitive(Long[] in) {
        long[] result = new long[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }

    public static float[] primitive(Float[] in) {
        float[] result = new float[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }

    public static double[] primitive(Double[] in) {
        double[] result = new double[in.length];
        for (int i = 0; i < in.length; i++) {
            result[i] = in[i];//Autounboxing 自动拆箱
        }
        return result;
    }
}
