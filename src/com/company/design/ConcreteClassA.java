package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class ConcreteClassA extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("ConcreteClassA#doSomething()");
    }
    @Override
    protected void doAnything() {
        System.out.println("ConcreteClassA#doAnything()");
    }
}
