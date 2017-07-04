package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/4 22:10
 * @Modified:
 */
public abstract class Event {
    /*
    * 首先，接口描述了要控制的事件。因为其默认的行为是基于事件去执行控制，所以使用抽象类
    * 代替实际的接口。
    *
    * 当希望运行Event并随后调用start()时，那么构造器就会捕获（从对象创建的时候开始的）时间，此时间是这样得
    * 来的:start()获取当前时间，然后加上一段延时时间delayTime,这样生成触发事件时间。start()是一个独立的方法
    * ，而没有包含在构造器内，因为这样就可以在事件运行以后重新启动计时器，也就是能够重复使用Event对象。例如，如果
    * 想要重复一个事件，只需简单地在action()中调用start()方法。
    * ready()告诉你何时可以运行action()方法了。当然，可以在导出类中覆盖ready()方法，使得Event能够基于时间
    * 以外的其他因素而触发。
    *
    *
    *
    *
    *
    * */
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }

    public void start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
