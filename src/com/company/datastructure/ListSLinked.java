package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/9.
 */
public class ListSLinked implements List {
    private Strategy strategy;
    private SLNode head;
    private int size;

    public ListSLinked() {
        this(new DefaultStrategy());
    }

    public ListSLinked(Strategy strategy) {
        this.strategy = strategy;
        this.head = new SLNode();
        this.size = 0;
    }

    // 辅助方法：获取数据元素e所在节点的前驱节点
    private SLNode getPreNode(Object e) {
        SLNode p = this.head;
        while (p.getNext() != null)
            if (this.strategy.equal(p.getNext().getData(), e)) {
                return p;
            } else {
                p = p.getNext();
            }
        return null;
    }

    // 辅助方法：获取序号为0 <=i<size的元素所在节点的前驱节点
    private SLNode getPreNode(int i){
        SLNode p = this.head;
        for (; i > 0; i--) {
            p = p.getNext();
        }
        return p;
    }

    // 获取序号为0 <= i < size的元素所在节点
    private SLNode getNode(int i) {
        SLNode p = this.head.getNext();
        for (; i > 0; i--) {
            p = p.getNext();
        }
        return p;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        SLNode p = this.head.getNext();
        while (p != null)
            if (this.strategy.equal(p.getData(), e)){
                return true;
            } else {
                p = p.getNext();
            }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        SLNode p = this.head.getNext();
        int i = 0;
        while (p != null){
            if (this.strategy.equal(p.getData(),e)){
                return i;
            } {
                p = p.getNext();
                i++;
            }
        }
        return -1;
    }

    @Override
    public void insert(int i, Object e) throws OutOfBoundaryException {
        if (i<0 || i>size)
            throw new OutOfBoundaryException("错误，指定的插入序号越界。");
        if (i == 0) {
            SLNode q = new SLNode(e, this.head.getNext());
            this.head.setNext(q);
        } else {
            SLNode p = getNode(i);
            SLNode q = new SLNode(e, p.getNext());
            p.setNext(q);
        }
        size++;
        return ;
    }

    public void add(Object e) {
        SLNode p = this.head;
        while (p.getNext() != null) {
            p = p.getNext();
        }
        SLNode q= new SLNode(e, null);
        p.setNext(q);
        size++;
    }

    @Override
    public boolean insertBefore(Object obj, Object e) throws OutOfBoundaryException {
        SLNode p = getPreNode(obj);
        if (p != null) {
            SLNode q = new SLNode(e, p.getNext());
            p.setNext(q);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean insertAfter(Object obj, Object e) throws OutOfBoundaryException {
        SLNode p = head.getNext();
        while (p != null){
            if (strategy.equal(p.getData(), obj)){
                SLNode q = new SLNode(e, p.getNext());
                p.setNext(q);
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object remove(int i) throws OutOfBoundaryException {
        if (i<0 || i>size)
            throw new OutOfBoundaryException("");
        SLNode p = getPreNode(i);
        Object obj = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        size--;
        return obj;
    }

    @Override
    public boolean remove(Object e) throws OutOfBoundaryException {
        SLNode p = getPreNode(e);
        if (p != null){
            p.setNext(p.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Object replace(int i, Object e) throws OutOfBoundaryException {
        if (i<0 || i>size)
            throw new OutOfBoundaryException("");
        SLNode p = getNode(i);
        Object obj = p.getData();
        p.setData(e);
        return obj;
    }

    @Override
    public Object get(int i) throws OutOfBoundaryException {
        if (i<0 || i>size)
            throw new OutOfBoundaryException("");
        SLNode p = getNode(i);
        return p.getNext();
    }

    @Override
    public String toString() {
        SLNode p = this.head.getNext();
        while (p != null) {
            System.out.println("data: "+ p.getData());
            p = p.getNext();
        }
        return super.toString();
    }

    public static void main(String[] args) throws OutOfBoundaryException{
        ListSLinked listSLinked = new ListSLinked(new DefaultStrategy());
        for (int i = 0; i < 10; i++) {
            listSLinked.add(i);
        }
        listSLinked.insert(4, 44);
        listSLinked.replace(0, 111);
        listSLinked.toString();
    }
}
