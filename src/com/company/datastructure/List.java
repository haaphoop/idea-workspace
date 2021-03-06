package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/9.
 */
public interface List {
    // 返回线性表的大小，即数据元素的个数
    int getSize();

    // 如果线性表为空，返回true， 否则返回false
    boolean isEmpty();

    // 判断线性表是否包含元素e
    boolean contains(Object e);

    // 返回元素e在线性表中的序号
    int indexOf(Object e);

    // 将元素e插入到线性表中i号位置
    void insert(int i, Object e) throws OutOfBoundaryException;

    // 将元素e插入到元素obj之前
    boolean insertBefore(Object obj, Object e) throws OutOfBoundaryException;

    // 将元素e插入到元素obj之后
    boolean insertAfter(Object obj, Object e) throws OutOfBoundaryException ;

    // 删除线性表中序号为i的元素，并返回之
    Object remove(int i) throws OutOfBoundaryException;

    // 删除线性表中第一个与e相同的元素
    boolean remove(Object e) throws OutOfBoundaryException ;

    // 替换线性表中序号为i的数据元素为e，返回原数据元素
    Object replace(int i, Object e) throws OutOfBoundaryException;

    // 返回线性表中序号为i的数据元素
    Object get(int i) throws OutOfBoundaryException;
}
