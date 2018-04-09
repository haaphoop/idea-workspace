package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class Facde {
    private ClassA classA = new ClassA();
    private ClassB classB = new ClassB();
    private ClassC classC = new ClassC();
    private Context context = new Context();
    public void doSomethingA(){
        this.classA.doSomethingA();
    }

    public void doSomethingB(){
        this.classB.doSomethingB();
    }

    public void doSomethingC(){
        this.context.methodc();
       /* this.classA.doSomethingA();
        this.classC.doSomethingC();*/
    }
}
