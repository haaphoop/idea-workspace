package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/9.
 */
public class SLNode implements Node {
    private Object element;
    private SLNode next;

    public SLNode(Object element, SLNode next) {
        this.element = element;
        this.next = next;
    }

    public SLNode() {
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

    @Override
    public Object getData() {
        return this.element;
    }

    @Override
    public void setData(Object obj) {
        this.element = obj;
    }
}
