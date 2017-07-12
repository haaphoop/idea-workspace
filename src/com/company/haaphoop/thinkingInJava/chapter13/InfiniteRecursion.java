package com.company.haaphoop.thinkingInJava.chapter13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/12 22:31
 * @Modified:
 */
public class InfiniteRecursion {
    /*
    * 运行该程序会发生异常，这是由于运行代码：“InfiniteRecursion address: ” + this 这里发生了自动类型转换，
    * 由InfiniteRecursion类型转换成String类型。因为编译器看到一个String对象后面跟着一个"+",而再后面的对象不是
    * String,于是编译器试着将this转换成一个String。它怎么转换呢，正式通过调用this上的toString()方法，于是就发生了
    * 递归调用。
    * 如果你真的想要打印出对象的内存地址，应该调用Object.toString()方法，这才是负责此任务的方法。所以，你不该使用this,
    * 而是应该调用super.toString()方法。
    *
    * */
    @Override
    public String toString() {
        return " InfiniteRecursion address: " + this + "\n";
        //return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> list = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; i++) {
            list.add(new InfiniteRecursion());
        }

        System.out.println(list);
    }
}
