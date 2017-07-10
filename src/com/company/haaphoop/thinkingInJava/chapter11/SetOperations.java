package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 22:35
 * @Modified:
 */
public class SetOperations {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Collections.addAll(set,"A B C D E F G H I J K L".split(" "));
        set.add("M");
        System.out.println("H: " + set.contains("H"));
        System.out.println("N: " + set.contains("N"));
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1, "H I J K L".split(" "));
        System.out.println("set1 in set: " + set.containsAll(set1));
        set.remove("H");
        System.out.println("set : " + set);
        System.out.println("set1 in set : " + set.containsAll(set1));
        set.remove(set1);
        System.out.println("set1 removed from set: " + set);
        Collections.addAll(set, "X Y Z".split(" "));
        System.out.println(set);

    }
}
