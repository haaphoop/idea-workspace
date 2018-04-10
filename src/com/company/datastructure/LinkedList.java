package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/10.
 */
public interface LinkedList {
    // 查询链接表当前的规模
    int getSize();
    // 判断列表是否为空
    boolean isEmpty();
    // 返回第一个节点
    Node first() throws OutOfBoundaryException;
    // 返回最后一个节点
    Node last() throws OutOfBoundaryException;
    // 返回p之后的节点
    Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException;
    // 返回p之前的节点
    Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException;
    // 将e作为第一个元素插入链接表，并返回e所在节点
    Node insertFirst(Object e);
    // 将e作为最后一个元素插入链接表，并返回e所在节点
    Node insertLast(Object e) throws InvalidNodeException, OutOfBoundaryException;
    // 将e插入至p之后的位置，并返回e所在节点
    Node insertAfter(Node p, Object e) throws InvalidNodeException;
    // 将e插入至p之前的位置，并返回e所在节点
    Node insertBefore(Node p, Object e) throws InvalidNodeException;
    // 删除给定位置处的元素，并返回之
    Object remove(Node p) throws InvalidNodeException;
    // 删除首元素，并返回之
    Object removeFirst() throws InvalidNodeException,OutOfBoundaryException;
    // 删除尾元素，并返回之
    Object removeLast() throws InvalidNodeException,OutOfBoundaryException;
    // 将处于给定位置的元素替换为新元素，并返回被替换的元素
    Object replace(Node p, Object e) throws InvalidNodeException;
    // 元素迭代器
    Iterator elements()throws OutOfBoundaryException;
}
