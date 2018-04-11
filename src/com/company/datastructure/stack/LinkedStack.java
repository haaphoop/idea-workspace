package com.company.datastructure.stack;

public class LinkedStack implements Stack {
    private StackNode top;
    private int size;

    public LinkedStack() {
        top = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(Object object) {
        StackNode stackNode = new StackNode(object, top);
        top = stackNode;
        size++;
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (top == null)
            throw new StackEmptyException("");
        Object object = top.getValue();
        top = top.getNext();
        size--;
        return object;
    }

    @Override
    public Object peek() throws StackEmptyException {
        if (top == null)
            throw new StackEmptyException("");
        return top.getValue();
    }
}
