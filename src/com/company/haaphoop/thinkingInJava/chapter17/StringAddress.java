package com.company.haaphoop.thinkingInJava.chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

/*
* 这个示例展示了两种用对单个对象的引用来填充Collection的方式，第一种是使用Collections.nCopies()创建传递给构造器的List
* 这里填充的是ArrayList。
* StringAddres的toString()方法调用Object.toString()
* 并产生该类的名字，后面紧跟该对象的散列码的无符号十六进制表示（通过hashCode()
* 生成的）。从输出中可以看到所有引用都被设置为指向相同的对象，在第二种方法的Collection.fill()被调用之后也是如此。fill()
* 方法的用处更有限，因为它只能替换已经在List中存在的元素，而不能添加新的元素。
* */
class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(
                Collections.nCopies(4,  new StringAddress("Hello"))
        );

        System.out.println(list);
        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}