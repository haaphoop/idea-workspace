package com.company.haaphoop.thinkingInJava.chapter17;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.ArrayList;

/*
* 这个类使用Generator在容器中放置所需数量的对象，然后所产生的容器可以传递给任何Collection的构造器，
* 这个构造器会把其中的数据复制到自身中。addAll()方法是所有Collection子类型的一部分，它也可以用来组装现有的Colleciton.
*   泛型便利用方法减少在使用类时所必需的类型检查数量。
*   CollectionData是适配器设计模式的一个实例，它将Generator适配到Collection的构造器上。
*
* */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(int initialCapacity, Generator<T> generator) {
        for (int i = 0; i < initialCapacity; i++) {
            add(generator.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> generator, int
            quantity) {
        return new CollectionData<T>(quantity, generator);
    }
}
