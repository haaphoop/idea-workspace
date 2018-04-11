package com.company.datastructure.stack;

public class StackNode {
    private Object value;
    private StackNode next;

    public StackNode(Object value, StackNode next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
