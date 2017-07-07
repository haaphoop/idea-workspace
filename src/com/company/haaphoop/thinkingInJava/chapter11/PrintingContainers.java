package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.*;

/**
 * Created by daishuli on 2017/7/7.
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat","Fuzzy");
        map.put("cat","Rags");
        map.put("dog","Bosco");
        map.put("dog","Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()) + " ArrayList");
        System.out.println(fill(new LinkedList<String>()) + " LinkedList");
        System.out.println(fill(new HashSet<String>()) + " HashSet");
        System.out.println(fill(new TreeSet<String>()) + " TreeSet");
        System.out.println(fill(new LinkedHashSet<String>()) + " LinkedHashSet");
        System.out.println(fill(new HashMap<String,String>()) + " HashMap");
        System.out.println(fill(new TreeMap<String,String>()) + " TreeMap");
        System.out.println(fill(new LinkedHashMap<String,String>()) + " LinkedHashMap");

        /*
        * 这里展示了Java容器类库中的两种主要类型，它们的区别在于容器中每个“槽”保存的元素个数。Collection在每个槽中只保存一个元素。此类容
        * 器包括：list,它以特定的顺序保存一组元素；set,元素不能重复；queue，只允许在容器的一端插入对象，并从另外一端移除对象；map，在每个槽内
        * 保存了两个对象，即键和与之相关联的值。
        *第一个fill()方法可以作用于所有类型的Collection,这些类型都实现了用来添加新元素的add()方法。
        * ArrayList和LinkedList都是list类型，从输出可以看出，它们都按照被插入的顺序保存元素。两者的不同之处不仅在于某些类型的操作时的性能，而且
        * linkedList包含的操作也多于arrayList。
        * HashSet TreeSet和linkedHashSet都是set类型，输出显示在Set中，每个相同的相只保存一次，但是输出也显示了不同的set实现存储元素的方式也不同
        * HashSet使用的是相当复杂的方式来存储元素的，这种技术是最快的获取元素方式，因此，存储的顺序看起来毫无意义。如果存储顺序很重要，那么可以
        * 使用TreeSet,它按照比较结果的升序保存对象，或者使用LinkedHashSet，它按照被添加的顺序保存对象.
        * Map（也被称为关联数组）使得你可以用键来查找对象，就像一个简单的数据库。键所关联的对象成为值。
        *
        *
        * */
    }
}
