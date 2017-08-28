package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.Arrays;
import java.util.Collections;

/*
* 注意，String排序算法依据字典编排顺序排序，所以大写字母开头的词都放在前面输出，然后才是小写字幕开头的词。如果
* 想忽略大小写字母将单词都放在一起排序，那么可以像上例中最后一个对sort()的调用一样，使用String。CASE_INSENSITIVE_ORDER。
* java标准类库中的排序算法针对正排序的特殊类型进行了优化---针对基本类型设计的“快速排序”(Quicksort)，以及针对对象设计的“稳定
* 归并排序”。所以无须担心排序的性能，除非你可以证明排序部分的确是程序效率的瓶颈。
* */
public class StringSorting {
    public static void main(String[] args) {
        String[] a = Generated.array(new String[20], new RandomGenerator
                .String(5));
        System.out.println("befogr sort: ");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sort: " + Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("reverse sort:" + Arrays.toString(a));
        Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + Arrays.toString(a));
    }
}
