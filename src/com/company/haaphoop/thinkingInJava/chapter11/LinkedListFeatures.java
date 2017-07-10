package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 21:35
 * @Modified:
 */
public class LinkedListFeatures {
    /*
    * Queue接口，在LinkedList的基础上添加了element()、offer()、peek()、poll()、和remove()方法，以使其可以成为一个queue的实现。
    *
    * */
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        Collections.addAll(linkedList, "Rat","Manx", "Cymric","Mutt", "Pug", "Cymric", "Pug", "Manx");
        System.out.println(linkedList);
        System.out.println("linkedList.getFirst(): " + linkedList.getFirst());
        System.out.println("linkedList.element(): " + linkedList.element());

        System.out.println("linkedList.peek(): " + linkedList.peek());
        System.out.println("linkedList.remove(): " + linkedList.remove());
        System.out.println("linkedList.removeFirst(): " + linkedList.removeFirst());
        System.out.println("linkedList.poll() :" + linkedList.poll());
        System.out.println(linkedList);
        linkedList.addFirst("Rat");
        System.out.println("After addFirst() : " + linkedList);
        linkedList.offer("daddddd");
        System.out.println("After offer() : " + linkedList);
        linkedList.add("test");
        System.out.println("After add() : " + linkedList);
        linkedList.addLast("last");
        System.out.println("After addLast() : " + linkedList);
        System.out.println("removeLast() : " + linkedList.removeLast());
    }
}
