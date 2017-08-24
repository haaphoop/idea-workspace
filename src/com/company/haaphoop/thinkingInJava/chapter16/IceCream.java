package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.Arrays;
import java.util.Random;

/*
* 方法flavorSet()方法创建了一个名为results的String数组。此数组容量为n，由传入方法的参数决定。然后从数组FLAVORS中
* 随机选择元素，存入results数组中，它是方法所最终返回的数组。返回一个数组与返回任何其他对象没什么区别。数组是在flavorSet()
* 中被创建还是在别的地方被创建，这一定并不重要。但使用完毕后，垃圾回收器负责清理数组；而只要还需要它，此数组就会一直存在。
*
* 说句题外话，注意当flavorSet()随机选择各种数组元素“味道”时，它确保不会重复选择。由一个do循环不断进行随机选择，直到找出
* 一个在数组picked中还不存在的元素。（当然，还会比较String以检查随机选择的元素是否已经在数组results
* 中。）如果成功，将此元素加入数组，然后查找下一个。
* */
public class IceCream {
    private static Random random = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
    };

    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = random.nextInt(FLAVORS.length);
            } while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
            System.out.println(t);
        }
        System.out.println(Arrays.toString(picked));
        return results;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(flavorSet(8)));
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(7)));
        }
    }
}
