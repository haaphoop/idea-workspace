package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/6/30.
 */
public class Sequence {
    /*
    * Sequence类只是一个固定大小的Object的数组，以类的形式包装了起来。可以调用add()在序列末增加新的Object(只要还有空间)。
    * 要获取Sequence中的每一个对象，可以使用Selector接口。这是“迭代器”设计模式的一个例子，在本书稍后部分将更多地学习它。
    * Selector允许你检查序列是否到末尾（end()）了，访问当前对象(current())，以及移动到序列中的下一个对象(next())。因为Selector
    * 是一个接口，所以别的类可以按它们自己的方式来实现这个接口，并且别的方法能以此接口为参数，来生成更加通用的代码。这里，SequenceSelector
    * 是提供Selector功能的private类。可以看到，在main()中创建了一个Sequence，并向其中添加了一些String对象。然后通过调用getSelector()
    * 获取一个Selector,并用它在Sequence中移动和选择每一个元素。
    *
    *
    * */
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {items = new Object[size];}
    public void add(Object object) {
        if (next < items.length) {
            items[next++] = object;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i != items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector getSelector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.getSelector();
        while (selector.end()) {
            System.out.print(selector.current() + "  ");
            selector.next();
        }
    }
}
interface Selector {
    boolean end();
    Object current();
    void next();
}