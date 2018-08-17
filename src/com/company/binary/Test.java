package com.company.binary;

/**
 * Created by daishuli on 2018/5/2.
 */
public class Test {
    public static void main(String[] args) {
        int a = -15, b=11;
        byte b1 = -128;
        System.out.println(Integer.toBinaryString(-8>>1));
        System.out.println(Byte.toString(b1));
        System.out.println(~b);
        int n = 11;
        int count = 0;
        System.out.println(Integer.toBinaryString(n));
        while (n != 0) {
            n = (n-1) & n;
            System.out.println("循环：" + n);
        }
        System.out.println(count);

        //System.out.println(Power(10,3));
        long before = System.currentTimeMillis();
        int time = 100000000;
        while (time > 0) {
            time -=1;
        }
        System.out.println("time -=1:"+(System.currentTimeMillis() - before));
        before = System.currentTimeMillis();
        time = 100000000;
        while (time-- > 0) {}
        System.out.println("time-1:"+(System.currentTimeMillis() - before));
    }

    public static long Power(long base, int exponent) {
        long temp = 1;
        if (exponent >= 0) {
            while (exponent-- > 0) {
                temp = temp * base;
            }
        } else {
            while (exponent++ > 0) {
                temp = temp * base;
            }
        }
        return temp;
    }
}
