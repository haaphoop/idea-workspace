package com.company.datastructure.queue;

public class QueueNode {
    private Object value;
    private QueueNode next;

    public QueueNode(Object value, QueueNode next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
