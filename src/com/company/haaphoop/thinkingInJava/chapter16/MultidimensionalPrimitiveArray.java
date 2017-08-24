package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.Arrays;
import java.util.Random;

/*
* 每对花括号括起来的集合都会把你带到下一级数组。使用Arrays.deepToString()方法，它可以将多维数组转换为多个String，正如从
* 输出中所看到的那样。还可以使用new来分配数组，下面的三维数组就是在new 表达式中分配的：
* */
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},{4, 5, 6}};
        System.out.println(Arrays.deepToString(a));

        // 3-D array with fixed length
        //int [][][] b = {{{1,2,3,4},{5,6,7,8}},{{9,1,2,3},{4,5,6,7}}};
        int [][][] c = new int[2][2][4];
        //System.out.println(Arrays.deepToString(b));
        /*
        * 你可以看到基本类型数组的值在不进行显式初始化的情况下，会被自动初始化。对象数组会被初始化为null。
        * 数组中构成矩阵的每个向量都可以具有任意的长度（这被称为粗糙数组）：
        * */
        System.out.println(Arrays.deepToString(c));

        //Random random
    }
}
