package com.company.datastructure.singlelist;

/**
 * Created by daishuli on 2018/4/10.
 */
public class SLNode {
    private Object element;
    private SLNode next;

    public SLNode(Object element) {
        this.element = element;
    }

    public SLNode(Object element, SLNode next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }
}
