package com.company.datastructure.sort;

/**
 * Created by daishuli on 2018/4/13.
 */
public interface Strategy<T> {
    // 判断两个数据元素是否相等
    boolean equal(T obj1, T obj2);

    /**
     * 比较两个数据元素的大小 如果obj1 < obj2 返回-1 如果obj1 = obj2 返回0 如果obj1 > obj2 返回1
     */
    int compare(T obj1, T obj2);
}
