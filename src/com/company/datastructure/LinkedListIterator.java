package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/10.
 */
public class LinkedListIterator implements Iterator {
    private LinkedList list;
    private Node current;
    public LinkedListIterator(LinkedList list) throws OutOfBoundaryException{
        this.list = list;
        if (list.isEmpty())
            current = null;
        else
            current = list.first();
    }

    @Override
    public void first() {
        if (list.isEmpty())
            current = null;
        else
            try {
                current = list.first();
            } catch (OutOfBoundaryException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void next() throws OutOfBoundaryException {
        if (isDone())
            throw new OutOfBoundaryException("");
        if (current == list.last())
            current = null;
        else
            try {
                current = list.getNext(current);
            } catch (InvalidNodeException e) {
                e.printStackTrace();
            }
    }

    @Override
    public boolean isDone() {
        return current == null;
    }

    @Override
    public Object currentItem() throws OutOfBoundaryException{
        if (isDone())
            throw new OutOfBoundaryException("");
        return current.getData();
    }
}
