package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.Arrays;

public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        System.out.println(Arrays.equals(a1, a2));
        a2[3]  = 11;
        System.out.println(Arrays.equals(a1, a2));
        String[] s1 = new String[4];
        Arrays.fill(s1, "Hi");
        String[] s2 = {new String("Hi"), new String("Hi"),new String("Hi")
                , new String("Hi")};
        System.out.println(Arrays.equals(s1, s2));

        /*
        * 最初数组a1与a2完全相等，所以输出为true；然后改变其中一个元素，使得结果为false。在最后一个例子中，s1
        * 的所有元素都指向同一个对象，而数组s2包含五个相互独立的对象。然而，数组相等是基于内容的（通过Object.equals()
        * 比较），所以结果为true。
        * */
    }
}
