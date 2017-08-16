package com.company.haaphoop.thinkingInJava.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleProxyDemo1 {
}

/*
* 通过调用静态方法Proxy.newProxyInstance()可以创建动态代理，这个方法需要得到一个类加载器（
* 你通常可以从已经被加载得对象中获取其类加载器，然后传递给它），一个你希望该代理实现得接口列表（不是类或抽象类），
* 以及InvocationHandler接口得一个实现。动态代理可以将所有调用重定向到调用处理器，因此通常会向调用处理器得构造器传递给
* 一个“实际”对象得引用，从而使得调用处理器在执行其中任务时，可以将请求转发。
*   invoke（）方法中传递进来了代理对象，以防你需要区分请求得来源，但是在许多情况下，你并不关系这一点。然而，在invoke()
*   内部，在代理上调用方法时需要格外当心，因为对接口得调用将被重定向为对代理得调用。
* 通常，你会执行被代理得操作，然后使用Method.invoke()将请求转发给被代理对象，并传入必须得参数。这初看起来可能有些受限，就像你只能
* 执行泛化操作一样。但是，你可以通过传入其他得参数，来过滤某些方法调用：
*
*
* */
class DynamicProxHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public String toString() {
        return "DynamicProxHandler{" +
                "proxied=" + proxied +
                '}';
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws
            Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ".method: " +
                method + ".args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("   " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxHandler(realObject)
        );
        consumer(proxy);
    }
}
