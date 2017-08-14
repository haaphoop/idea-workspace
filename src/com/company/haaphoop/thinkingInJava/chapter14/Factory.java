package com.company.haaphoop.thinkingInJava.chapter14;

public interface Factory<F> {
    /*
    * 泛型参数T使得create()可以在每种Factory实现中返回不同的类型。这也充分利用了
    * 协变返回类型。
    * */
    F create();
}
