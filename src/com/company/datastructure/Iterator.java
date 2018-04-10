package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/10.
 */
public interface Iterator {
    // 移动到第一个元素
    void first();
    // 移动到下一个元素
    void next() throws OutOfBoundaryException;
    // 检查迭代器是否还有剩余的元素
    boolean isDone();
    // 返回当前元素
    Object currentItem() throws OutOfBoundaryException;
}
