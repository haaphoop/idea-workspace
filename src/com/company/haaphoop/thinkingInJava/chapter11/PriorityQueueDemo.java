package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.*;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/11 21:07
 * @Modified:
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);
        System.out.println("=====");
        List<Integer> list = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<Integer>(list);
        QueueDemo.printQ(priorityQueue);
        System.out.println("=====");
        priorityQueue = new PriorityQueue<Integer>(list.size(), Collections.reverseOrder());
        priorityQueue.addAll(list);
        QueueDemo.printQ(priorityQueue);
        System.out.println("=====");
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
        QueueDemo.printQ(stringPQ);
        System.out.println("=====");
        stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);
        System.out.println("=====");

        Set<Character> charSet = new HashSet<Character>();
        for (char c : fact.toCharArray()) {
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(characterPQ);
        /*
        * 可以看到，重复是允许的，最小的值拥有最高的有限级（如果是String，空格也可以算作值，并且比字母优先级高）。为了展示你可以使
        * 用怎样的方法通过提供自己的Comparator对象来改变排序，第三个对PriorityQueue<Integer>的构造器调用，和第二个对PriorityQueue
        * <String>的调用使用了由Collection.reverseOrder()（新添加到Java SE5中的）产生的反序的Comparator。
        * 最后一部分添加了一个HashSet来消除重复的Charactor，这么做只是为了增添点乐趣。Integer、String和Character可以与PriorityQueue
        * 一起工作，因为这些类已经内建了自然排序。如果你想在PriorityQueue中使用自己的类，就必须包括额外的功能以自然排序，或者必须提供
        * 自己的Comparator。
        * */
    }
}
