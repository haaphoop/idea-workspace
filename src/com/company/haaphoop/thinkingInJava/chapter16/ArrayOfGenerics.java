package com.company.haaphoop.thinkingInJava.chapter16;

import com.sun.jndi.ldap.Ber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 一旦拥有了对List<String>[]的引用，你就会看到你将得到某些编译器检查。问题是数组是协变类型的，因此List<String>[]也是
* 一个Object[]，并且你可以利用这一点，讲一个ArrayList<Integer>赋值到你的数组中，而不会有任何编译器或运行时错误。
* 如果你知道将来不会向上转型，并且需求也相对比较简单，那么你仍旧可以创建泛型数组，它可以提供基本的编译器类型检查。但是，事实上，泛型容器总是比
* 泛型数据更好的选择。
* 一般而言，你会发现泛型在类或方法的边界处很有效，而在类或方法的内部，擦除通常会使泛型变得不适用，例如，你不能创建泛型数组：
* ArrayOfGenericType.java
*
* */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;
        ls[0] = new ArrayList<String>();
        //ls[1] = new ArrayList<Integer>();
        Object[] objects = ls;

        objects[1] = new ArrayList<Integer>();

        List<BerylliumSphere>[] lists = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<BerylliumSphere>();
        }

        System.out.println(Arrays.toString(lists));
    }
}
