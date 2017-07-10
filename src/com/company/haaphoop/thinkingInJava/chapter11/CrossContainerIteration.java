package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.*;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 20:47
 * @Modified:
 */
public class CrossContainerIteration {

    public static void display(Iterator<String> iterator){
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.print(s + " : ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(8);
        Collections.addAll(list,"Rat","Manx", "Cymric","Mutt", "Pug", "Cymric", "Pug", "Manx");

        LinkedList<String> linkedList = new LinkedList<String>(list);
        HashSet<String> hashSet = new HashSet<String>(list);
        TreeSet<String> treeSet = new TreeSet<String>(list);
        display(list.iterator());
        display(linkedList.iterator());
        display(hashSet.iterator());
        display(treeSet.iterator());
    }

    /*
    * 注意：display()方法不包含任何有关它所遍历的序列的类型信息，而这也展示了Iterator的真正威力：能够将遍历序列的操作与序列底层的结构
    * 分离。正由于此，我们有时会说：迭代器统一了对容器的访问方式。
    * */

}
