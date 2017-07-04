package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/4 21:10
 * @Modified:
 */
public class Callbacks {
    /*
    * 这个例子进一步展示了外围类实现一个接口与内部类实现此接口之间的区别。就代码而言，Calleel是简单的解决方式。Calleel2继承自
    * MyIncrement，后者已经有了一个不同的increment()方法，并且与Incrementable接口期望的increment()方法完全不相关。所以如果
    * Calleel2继承了MyIncrement，就不能为了Incrementable接口期望的用途而覆盖increment()方法，于是只能使用内部类独立地实现
    * Incrementable。还要注意，当创建了一个内部类时，并没有在外围类的接口中添加东西，也没有修改外围类的接口。
    * 注意，在Calleel2中除了getCallbackReference以外，其他成员都是private的。要想建立与外部世界的任何连接，interface Incrementable
    * 都是必需的。在这里可以看到，interface是如何允许接口与接口的实现完全独立的。
    * 内部类Closure实现了Incrementable，以提供一个返回Calleel2的“钩子”（hook）--并且是一个安全的钩子。无论谁获得此Incrementable的
    * 引用，都只能调用increment()，除此以外没有其他功能。
    * Caller构造器需要一个Incrementable的引用作为参数，然后在以后得某个时刻，Caller对象可以使用此引用回调Callee类。
    *
    * */
    public static void main(String[] args) {
        Calleel calleel = new Calleel();
        Calleel2 calleel2 = new Calleel2();
        MyIncrement.f(calleel2);
        Caller caller1 = new Caller(calleel);
        Caller caller2 = new Caller(calleel2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}

interface Incrementable{void increment();}

class Calleel implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment(){
        System.out.println("Other Operation");
    }
    static void f(MyIncrement myIncrement) {myIncrement.increment();}
}

class Calleel2 extends MyIncrement {
    private int i = 0;
    public void increment(){
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Calleel2.this.increment();
        }
    }

    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable incrementable){callbackReference = incrementable;}
    void go(){callbackReference.increment();}
}