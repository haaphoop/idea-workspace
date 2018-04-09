package com.company.haaphoop.thinkingInJava.chapter17;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(15, new Goverment())
        );
        set.addAll(CollectionData.list(new Goverment(), 15));
        System.out.println(set);

        /*
        * 这些元素的顺序与它们的插入顺序心相同，因为LinkedHashSet 维护的是保持了插入顺序的链接列表.
        * 在第16章中定义的所有操作符现在通过CollectionData
        * 适配器都是可用的。下面是使用了其中两个操作符的示例：CollectionDataGenerator.java
        * */
        // output:[strange, women, lying, in, ponds, distributing, swords, is, no, barsis, for, a, system, of, goverment]
    }
}

class Goverment implements Generator<String> {
    String[] foundation = ("strange women lying in ponds " + "distributing" +
            " " +
            "swords is no barsis for a system of " + "goverment").split("" +
            " ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}