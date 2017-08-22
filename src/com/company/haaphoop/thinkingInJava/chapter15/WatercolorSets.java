package com.company.haaphoop.thinkingInJava.chapter15;

import java.util.EnumSet;
import java.util.Set;

public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILIANT_RED,
                Watercolors.CRIMSON);
        Set<Watercolors> set2 = EnumSet.range(Watercolors.DEEP_YELLOW,
                Watercolors.LEMON_YELLOW);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        Set<Watercolors> subset = Sets.intersection(set1, set2);
        System.out.println(subset);
    }
}
