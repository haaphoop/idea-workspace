package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/11 20:46
 * @Modified:
 */
public class QueueDemo {
    /*
    * offer()方法是Queue相关的方法之一，它在允许的情况下，将一个元素插入到对尾，或者返回false。peek()和element()都将在不移除的情况下
    * 返回队头，但是peek()方法在队列为空时返回null，而element()会抛出NoSuchElementException异常。poll()和remove()方法将移除并
    * 返回队头，但是poll()在队列为空时返回null,而remove()会抛出NoSuchElementException异常。
    * 自动包装机制会自动地将nextInt()方法的int结果转换为queue所需的Integer对象，将char c 转换为queue1所需的Character对象。Queue接口窄化了对
    * LinkedList的方法的访问权限，以使得只有恰当的方法才可以使用，因此，你能够访问的LinkedList的方法会变少
    * 注意，与Queue相关的方法提供了完整而独立的功能，即，对于Queue所继承的Collection,在不需要使用它的任何方法的情况下，就可以拥有一个
    * 可用的Queue.
    *
    * */
    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        System.out.println(queue);
        Queue<Character> queue1 = new LinkedList<Character>();
        for (char c : "Brontosaurus".toCharArray()) {
            queue1.offer(c);
        }
        printQ(queue1);
    }
}
