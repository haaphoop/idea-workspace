package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/6 21:38
 * @Modified:
 */
public class SimpleCollection {
    /*
    * 这个示例只使用了Collection方法，因此，任何继承自Collection的类的对象都可以正常工作，但是ArrayList是
    * 最基本的序列类型。
    * add()方法的名称就表明它是要将一个新元素放置到Collection中。但是，文档中非常仔细地叙述到：“要确保这个
    * Collection包含指定的元素。”这是因为考虑到了Set的含义，因为在Set中只有元素不存在的情况下才会添加。在使用
    * ArrayList，或者任何种类的list时，add()总是表示“把它放进去”，因为list不关心是否存在重复。
    *
    *
    * */
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }

        for (Integer i : collection) {
            System.out.println(i + " i");
        }
    }
}
