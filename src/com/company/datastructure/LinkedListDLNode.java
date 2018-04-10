package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/10.
 */
public class LinkedListDLNode implements LinkedList {
    private int size;
    private DLNode head;
    private DLNode tail;

    public LinkedListDLNode() {
        this.size = 0;
        this.head = new DLNode();
        this.tail = new DLNode();
        this.head.setNext(this.tail);
        this.tail.setPre(this.head);
    }

    // 辅助方法，判断节点p是否合法，如合法转换为DLNode
    protected DLNode checkPosition(Node p) throws InvalidNodeException{
        if (p == null)
            throw new InvalidNodeException("");
        if (p == head)
            throw new InvalidNodeException("");
        if (p == tail)
            throw new InvalidNodeException("");
        return (DLNode)p;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Node first() throws OutOfBoundaryException {
        if (isEmpty())
            throw new OutOfBoundaryException("");
        return this.head.getNext();
    }

    @Override
    public Node last() throws OutOfBoundaryException {
        if (isEmpty())
            throw new OutOfBoundaryException("");
        return tail.getPre();
    }

    @Override
    public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getNext();
        if (node == tail)
            throw new OutOfBoundaryException("");
        return node;
    }

    @Override
    public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getPre();
        if (node == head)
            throw new OutOfBoundaryException("");
        return node;
    }

    @Override
    public Node insertFirst(Object e) {
        DLNode p = new DLNode(e, this.head, this.head.getNext());
        this.head.getNext().setPre(p);
        this.head.setNext(p);
        this.size++;
        return p;
    }

    @Override
    public Node insertLast(Object e) throws InvalidNodeException, OutOfBoundaryException {
        DLNode p = new DLNode(e, this.tail.getPre(), this.tail);
        this.tail.getPre().setNext(p);
        this.tail.setPre(p);
        this.size++;
        return p;
    }

    @Override
    public Node insertAfter(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node, node.getNext());
        node.getNext().setPre(newNode);
        node.setNext(newNode);
        this.size++;
        return newNode;
    }

    @Override
    public Node insertBefore(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node.getPre(), node);
        node.getPre().setNext(newNode);
        node.setPre(newNode);
        this.size++;
        return newNode;
    }

    @Override
    public Object remove(Node p) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
        this.size--;
        return obj;
    }

    @Override
    public Object removeFirst() throws InvalidNodeException,OutOfBoundaryException {
        return remove(head.getNext());
    }

    @Override
    public Object removeLast() throws InvalidNodeException,OutOfBoundaryException {
        return remove(tail.getPre());
    }

    @Override
    public Object replace(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.setData(e);
        return obj;
    }

    @Override
    public Iterator elements() {
        return new LinkedListIterator(this);
    }
}
