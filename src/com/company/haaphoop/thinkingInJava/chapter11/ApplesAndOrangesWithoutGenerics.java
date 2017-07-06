package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/6 20:42
 * @Modified:
 */
public class ApplesAndOrangesWithoutGenerics {

    /*
    * Apple和Orange类是有区别的，它们除了都是Object之外没有任何共性（记住，如果一个类没有显式地声明继承自哪个类
    * 那么它自动地继承自Object）。因为ArrayList保存的是Object，因此你不仅可以通过ArrayList的add()方法将
    * Apple对象放进这个容器，还可以将Orange添加进去，而且无论在编译器还是运行时都不会有问题。当你在使用ArrayList
    * 方法来取出你认为是Apple的对象时，你得到的只是Object引用，必须将其转型为Apple，因此，需要将整个表达式
    * 括起来，在调用Apple的id()方法之前，强制执行转型。否则，你就会得到语法错误。在运行时，当你试图将orange对象
    * 转型为Apple时，你就会以前面提及的异常的形式得到一个错误。
    *
    *
    *
    * */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }

        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            ((Apple)apples.get(i)).id();
        }
    }

}

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id(){return id;}

    @Override
    public String toString() {
        return "apple";
    }
}

class Orange {

}
