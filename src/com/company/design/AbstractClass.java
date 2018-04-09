package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public abstract class AbstractClass {
    protected abstract void doSomething();
    protected abstract void doAnything();
    public void templateMethod() {
        this.doSomething();
        this.doAnything();
    }
}
