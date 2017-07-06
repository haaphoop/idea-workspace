package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.*;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/6 21:51
 * @Modified:
 */
public class AddingGroups {
    /*
    *
    * Collection的构造器可以接受另一个Collection，用它来将自身初始化，因此你可以使用Arrays.list()来为这个构造器
    * 产生输入。但是，Collections.addAll()方法运行起来要快的多，而且构建一个不包含元素的Collection，然后调用
    * Collections.addAll()这种方式很方便，因此它是首选方式。
    *
    * Collection.addAll()成员方法只能接受另一个Collection对象作为参数，因此它不如Arrays.list()和Collections.addAll()灵活，这两个方法
    * 使用的都是可变参数列表。
    * 你也可以直接使用Arrays.asList()的输出，将其当做list，但是在这种情况下，其底层表示的是数组，因此不能调整尺寸。如果你试图用
    * add()和delete()方法在这种列表中添加或删除元素，就有可能会引发去改变数组尺寸的尝试，因此你将在运行时获得"Unsupported Operation"错误。
    * Arrays.aslist()方法的限制是它对所产生的list做出了最理想的假设。
    * */
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        Integer[] moreInts = {8,9,10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11,12,13,14,15);
        Collections.addAll(collection,moreInts);
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,21);
        //list.add(99);
        for (Integer integer : collection) {
            System.out.println(integer + "integer");
        }
        for (Integer integer : list) {
            System.out.println(integer + "list");
        }
    }
}
