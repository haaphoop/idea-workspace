package com.company.datastructure.queue;

import java.util.EventListener;

public class ArrayQueue implements Queue {
    private static final int DEFAULT_LEN = 7;
    private int front, rear;
    private Object[] elements;
    private int capacity;

    public ArrayQueue() {
        this(DEFAULT_LEN);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity+1;
        elements = new Object[this.capacity];
        front = 0;
        rear = 0;
    }

    @Override
    public int getSize() {
        // 为什么要取余
        return (rear-front+capacity) % this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public void enqueue(Object o) {
        // 判断当前队列是否已满
        if (getSize() == (this.capacity-1))
            expendSpace();
        this.elements[rear] = o;
        rear = (rear + 1) % this.capacity;
    }
    private void expendSpace() {
        Object[] a = new Object[this.capacity*2];
        int i = front, j=0;
        while (i != rear) {
            a[j++] = elements[i];
            i = (i+1)%capacity;
            j++;
        }
        /*for (int i = 0; i < getSize(); i++) {
            a[i] = elements[front];
            front = (front+1) % this.capacity;
        }*/
        elements = a;
        front = 0;
        //rear = getSize();
        rear = j;
        this.capacity = this.capacity * 2;
    }
    @Override
    public Object dequeue() throws QueueEmptyException {
        if (front == rear)
            throw new QueueEmptyException("");
        Object obj = elements[front];
        elements[front] = null;
        front = (front+1)%this.capacity;
        return obj;
    }

    @Override
    public Object peek() throws QueueEmptyException {
        if (front == rear)
            throw new QueueEmptyException("");
        return elements[front];
    }
}