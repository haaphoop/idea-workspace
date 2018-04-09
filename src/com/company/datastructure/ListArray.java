package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/9.
 */
public class ListArray implements List {
    private final int default_len = 8; // 数组的默认大小
    private Strategy strategy; // 数据元素比较策略
    private int size;
    private Object[] elements;

    public ListArray() {
        this(new DefaultStrategy());
    }

    public ListArray(Strategy strategy) {
        this.strategy = strategy;
        this.size = 0;
        this.elements = new Object[this.default_len];
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
    public boolean contains(Object e) {
        for (int i=0; i<size; i++) {
            if (this.strategy.equal(e, this.elements[i]))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        for (int i=0; i<size; i++)
            if (this.strategy.equal(e, elements[i]))
                return i;
        return -1;
    }

    @Override
    public void insert(int i, Object e) throws OutOfBoundaryException {
        if (i < 0 || i > size)
            throw new OutOfBoundaryException("错误，指定的插入序号越界。" + i);
        if (size >= elements.length)
            expandSpace();// 扩容
        for (int j=size; j>i; j--)
            elements[j] = elements[j-1];
        elements[i] = e;
        size++;
        return ;
    }

    private void expandSpace() {
        Object[] a = new Object[elements.length*2];
        for (int i=0; i<elements.length; i++)
            a[i] = elements[i];
        elements = a;
    }

    @Override
    public boolean insertBefore(Object obj, Object e) throws OutOfBoundaryException {
        int i = indexOf(obj);
        if (i < 0)
            return false;
        insert(i, e);
        return true;
    }

    @Override
    public boolean insertAfter(Object obj, Object e)throws OutOfBoundaryException {
        int i = indexOf(obj);
        if (i<0)return false;
        insert(i+1, e);
        return true;
    }

    @Override
    public Object remove(int i) throws OutOfBoundaryException {
        if (i<0 || i>=size)
            throw new OutOfBoundaryException("错误，指定的删除序号越界。");
        Object obj = elements[i];
        for (int j=i; j< size-1; j++)
            elements[j] = elements[j+1];
        elements[--size] = null;
        return obj;
    }

    @Override
    public boolean remove(Object e) throws OutOfBoundaryException {
        int i = indexOf(e);
        if (i<0)return false;
        remove(i);
        return true;
    }

    @Override
    public Object replace(int i, Object e) throws OutOfBoundaryException {
        if (i<0 || i>=size)
            throw new OutOfBoundaryException("错误，指定的序号越界。");
        Object obj = elements[i];
        elements[i] = e;
        return obj;
    }

    @Override
    public Object get(int i) throws OutOfBoundaryException {
        if (i<0 || i>=size)
            throw new OutOfBoundaryException("错误，指定的删除序号越界。");
        return elements[i];
    }
}
