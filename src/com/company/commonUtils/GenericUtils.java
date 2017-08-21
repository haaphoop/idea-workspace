package com.company.commonUtils;

import java.util.*;

/*
* main()方法演示了如何使用这个工具类，类型参数推断避免了重复的泛型参数列表。
* */
public class GenericUtils {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> linkedList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> sls = GenericUtils.map();
        List<String> ls = GenericUtils.list();
        LinkedList<String> lls = GenericUtils.linkedList();
        Set<String> set = GenericUtils.set();
        Queue<String> qs = GenericUtils.queue();
    }
}
