package com.company.haaphoop.thinkingInJava.chapter15;

/*
* GenericMethods并不是参数化的，尽管这个类和其内部的方法可以被同时参数化，但是在这个例子中，孩子有方法f()拥有类型参数。
* 这是由该方法的返回类型参数列表指明的。
* 注意，当使用范型类时，必须在创建对象的时候指定类型参数的值，而使用泛型方法的时候，通常不必指明参数类型，而使用泛型方法的时候，通常不必
* 指明参数类型，因为编译器会为我们找出具体的类型。这称为类型参数推断。因此，我们可以像调用普通方法一样调用f()，而且就好像是f()被无限次地
* 重载过。它甚至可以接受GenericMethods作为其类型参数。
* 如果调用f()
* 时传入基本类型，自动打包机制就会介入其中，将基本类型的值包装为对应的对象。事实上，泛型方法与自动打包避免了许多以前我们不得不自己编写出来的代码。
* */
public class GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f("");
        genericMethods.f(1);
        genericMethods.f(1.0);
        genericMethods.f(1.0f);
        genericMethods.f('c');
        genericMethods.f(genericMethods);
        //genericMethods.f(null);
    }
}
