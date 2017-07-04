package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/4.
 */
public class AnonymousConstructor {
    /*
    * 匿名内部类通过实例初始化，实现匿名类的构造器效果
    *
    * 在此例中，不要求变量i一定是final的。因为i被传递给匿名类的基类的构造器，它并不会在匿名类内部被使用。
    * */
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(44);
        base.f();
    }
}

abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor i = " + i);
    }

    public abstract void f();
}
