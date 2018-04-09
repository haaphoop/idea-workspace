package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class Context {
    private ClassA classA = new ClassA();
    private ClassC classC = new ClassC();
    public void methodc() {
        this.classA.doSomethingA();
        this.classC.doSomethingC();
    }
}
