package com.company.haaphoop.thinkingInJava.chapter15;

import java.util.HashSet;
import java.util.Set;

/*
* 在前三个方法中，都将第一个参数Set复制了一份，将Set中的所有引用都存入一个新的HashSet对象中，
* 因此，我们并未直接修改参数中的Set。返回的值使一个全新的Set对象。
* 这四个方法表达了如下的数学集合操作：union()返回一个Set，它将两个参数合并在一起；
* intersection()返回的Set只包含两个参数的共有的部分；
* difference()方法从superest中移除subset包含的元素；
* complement()返回的Set包含除了交集之外的所有元素。
* 下面提供了一个enum，它包含各种水彩画的颜色
* */
public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.removeAll(b);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}

enum Watercolors {
    ZINC, LEMON_YELLOW, MEDIUM_YELLOW, DEEP_YELLOW, ORANGE,BRILIANT_RED,
    CRIMSON, MAGENTA, ROSE_MADDER, VIOLET
}
