package com.company.haaphoop.thinkingInJava.chapter16;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

public class Generated {
    public static <T> T[] array(T[] a, Generator<T> generator) {
        // CollectionData
        // .java将在第17章中定义，它将创建一个Collection对象，该对象中所填充的元素是由生成器generator
        // 产生的，而元素的数量则由构造器的第二个参数确定。所有的Collection子类型都拥有toArray()
        // 方法，该方法将使用Collection中的元素来填充参数数组。
        return new CollectionData<T>(generator, a.length).toArray(a);
    }

    /*
    * 这个方法使用反射来动态创建具有恰当类型和数量的新数组，然后使用与第一个方法相同的技术来填充该数组。
    * */
    public static <T> T[] array(Class<T> type, Generator<T> generator, int
            size) {
        T[] a = (T[])java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(generator, size).toArray(a);
    }
}
