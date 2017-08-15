package com.company.haaphoop.thinkingInJava.chapter14;

/*
* 因为consumer()接受得Interface,所以它无法知道正在获得的到底是RealObject还是SimpleProxy，因为这二者都实现了
* Interface。但是SimpleProxy已经被插入到了客户端和RealObject之间，因此它会执行操作，然后调用RealObject上相同的方法。
* */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse");
        proxied.somethingElse(arg);
    }
}

class SimpleProxyDemo {
    public static void consumer(Interface i) {
        i.doSomething();
        i.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy((new RealObject())));
    }
}
interface Interface {
    void doSomething();
    void somethingElse(String arg);
}