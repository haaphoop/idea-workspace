package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.Arrays;
import java.util.Comparator;

public class ComTypeComparator implements Comparator<ComType> {

    @Override
    public int compare(ComType o1, ComType o2) {
        return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
    }

    public static void main(String[] args) {
        ComType[] a = Generated.array(new ComType[12], ComType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new ComTypeComparator());
        System.out.println(Arrays.toString(a));
    }
}
