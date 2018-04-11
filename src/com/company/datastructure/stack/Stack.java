package com.company.datastructure.stack;

public interface Stack {
    // 返回栈中数据数量
    int getSize();
    // 是否为空栈
    boolean isEmpty();
    // 数据进栈
    void push(Object object);
    // 数据出栈
    Object pop() throws StackEmptyException;
    // 获取栈顶元素，不出栈
    Object peek()  throws StackEmptyException;
}
