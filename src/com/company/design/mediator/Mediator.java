package com.company.design.mediator;

/**
 * Created by daishuli on 2018/1/22.
 */
public abstract class Mediator {
    //定义同事类
    protected ConcreteColleague1 c1;
    protected ConcreteColleague2 c2;

    // 通过getter/setter方法把同事角色注入进来
    public ConcreteColleague1 getC1() {
        return c1;
    }

    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }

    public ConcreteColleague2 getC2() {
        return c2;
    }

    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }

    // 中介者模式的业务逻辑
    public abstract void doSomething1();
    public abstract void doSomething2();
}
