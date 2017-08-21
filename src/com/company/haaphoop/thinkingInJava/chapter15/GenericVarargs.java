package com.company.haaphoop.thinkingInJava.chapter15;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    /*
    * makeList()方法展示了与标准类库中java.util.Arrays.asList()方法相同的功能。
    * */
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
