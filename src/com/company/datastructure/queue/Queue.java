package com.company.datastructure.queue;

public interface Queue {
    int getSize();
    boolean isEmpty();
    void enqueue(Object o);
    Object dequeue() throws QueueEmptyException;
    Object peek() throws QueueEmptyException;
}
