package com.company.datastructure.stack;

public class ArrayStack implements Stack {
    private Object[] elements;
    private final int DEFAULT_LEN = 8;
    private int top;

    public ArrayStack() {
        this.top = -1;
        elements = new Object[DEFAULT_LEN];
    }

    @Override
    public int getSize() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void push(Object object) {
        if (getSize() >= elements.length)
            expendSpace();
        elements[++top] = object;
    }

    private void expendSpace() {
        Object[] newElement = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElement[i] = elements[i];
        }
        elements = newElement;
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (isEmpty())
            throw new StackEmptyException("");
        Object obj = elements[top];
        elements[top--] = null;
        return obj;
    }

    @Override
    public Object peek() throws StackEmptyException {
        if (isEmpty())
            throw new StackEmptyException("");
        return elements[top];
    }
}
