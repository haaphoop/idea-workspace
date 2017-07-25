package com.company.haaphoop.thinkingInJava.chapter14;

import java.util.Random;

/**
 * Created by daishuli on 2017/7/25.
 */
public class ClassInitialization {
    /*
    * 初始化有效地实现了尽可能的“惰性”。从对initable引用的创建中可以看到，仅使用.class语法来获得对类的引用不会引发初始化。但是，为了产生Class引用，Class.forName()立即就进行了初始化，就像在对initable3引用的创建中所看到的。如果一个static final值时“编译器常量”，就像Initable.staticFinal那样，那么这个值不需要对Initable类进行初始化就可以被读取。但是，如果只是将一个域设置为static和final的，还不足以确保这种行为，例如，对Initable.staticFinal2的访问将强制进行类的初始化，因为它不是一个编译器常量。
    * 如果一个static域不是final的，那么在对它访问时，总是要求在它被读取之前，要先进行链接和初始化，就像在对Initable2.staticNonFinal的访问中所看到的那样。
    * */
    public static Random random = new Random(47);

    public static void main(String[] args) throws Exception{
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        // 在非常数静态域进行首次引用时执行初始化
        System.out.println(Initable.staticFinal2);
        Class initable2 = Initable2.class;
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("com.company.haaphoop.thinkingInJava.chapter14.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}

class Base {
    static {
        System.out.println("base");
    }
}
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}
class Initable2 extends Base{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable3");
    }
}

