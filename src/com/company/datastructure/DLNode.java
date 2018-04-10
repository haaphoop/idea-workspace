package com.company.datastructure;

public class DLNode implements Node {

    private Object element;
    private DLNode pre;
    private DLNode next;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public DLNode getPre() {
        return pre;
    }

    public void setPre(DLNode pre) {
        this.pre = pre;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

    public DLNode() {
        this(null, null, null);
    }

    public DLNode(Object e) {
        this(e, null, null);
    }

    public DLNode(Object element, DLNode pre, DLNode next) {
        this.element = element;
        this.pre = pre;
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
