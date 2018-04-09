package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class ConcreteClassB extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("ConcreteClassB#doSomething()");
    }
    @Override
    protected void doAnything() {
        System.out.println("ConcreteClassB#doAnything()");
    }
}
