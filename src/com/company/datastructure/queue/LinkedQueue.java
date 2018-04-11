package com.company.datastructure.queue;

public class LinkedQueue implements Queue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public LinkedQueue() {
        this.size = 0;
        front = new QueueNode(null, null);
        rear = front;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object o) {
        QueueNode queueNode = new QueueNode(o, null);
        rear.setNext(queueNode);
        rear = rear.getNext();
        size++;
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty())
            throw new QueueEmptyException("");
        Object obj = front.getNext().getValue();
        front.setNext(front.getNext().getNext());
        size--;
        if (size < 1)
            rear = front;
        return obj;
    }

    @Override
    public Object peek() throws QueueEmptyException {
        if (isEmpty())
            throw new QueueEmptyException("");
        Object obj = front.getNext().getValue();
        return obj;
    }
}
