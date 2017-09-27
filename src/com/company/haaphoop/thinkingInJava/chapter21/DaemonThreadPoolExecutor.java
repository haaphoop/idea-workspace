package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    /*
    * 可以通过调用isDaemon()方法来确定线程是否是一个后台线程。如果是一个后台线程，那么它创建的
    * 任何线程将被自动设置成后台线程，如下例所示：Daemon.java
    * */
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new
                SynchronousQueue<Runnable>(),
                new DaemonThreadFactory());
    }
}

class Daemon implements Runnable {
    @Override
    public void run() {

    }
}