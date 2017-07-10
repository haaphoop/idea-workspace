package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 21:53
 * @Modified:
 */
public class Stack<T> {
    /*
    * 通过使用泛型，引入了在栈的类定义中最简单的可行示例。类名之后的<T>告诉编译器
    * 这将是一个参数化类型，而其中的类型参数，即在类被使用时将会被实际类型替换的参数，就是T。
    * 大体上，这个类是在声明“我们在定义一个可以持有T类型对象的Stack。” Stack是用LinkedList实现的，
    * 而LinkedList也被告知它将持有T类型对象。注意，push()接收的是T类型的对象，而peek()和pop()将返回
    * T类型的对象。peek()方法将提供栈顶元素，但是并不将其从栈顶移除，而pop()将移除并返回栈顶元素。
    * 如果你只需要栈的行为，这里使用继承就不合适了，因为这样会产生具有LinkedList的其他所有方法的类。
    * */
    private LinkedList<T> storage = new LinkedList<T>();
    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek(){
        return storage.getFirst();
    }

    public T pop(){
        return storage.removeFirst();
    }

    public boolean empty(){
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
