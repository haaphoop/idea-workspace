package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 22:18
 * @Modified:
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        Set<Integer> integers = new HashSet<Integer>();
        for (int i = 0; i < 30; i++) {
            integers.add(random.nextInt(30));
        }

        System.out.println(integers);
        System.out.println(integers.size());

        /*
        * 注意到，输出的顺序没有任何规律可循，这是因为处于速度原因的考虑，HashSet使用了散列。HashSet所维护的顺序与TreeSet或LinkedHashSet都不相同，因为他们具有不同的元素存储方式。TreeSet将元素存储在红-黑树数据结构中，而HashSet使用的是散列函数。LinkedHashSet因为查询速度的原因也使用了散列，
        * 但是看起来它使用了链表来维护元素的插入顺序。如果想对结果排序，一种方式是使用TreeSet来代替HashSet:
        * */
    }
}
