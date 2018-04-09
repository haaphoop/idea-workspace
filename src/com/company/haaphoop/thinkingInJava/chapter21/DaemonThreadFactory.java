package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.concurrent.ThreadFactory;

/*
* 这与普通的ThreadFactory的唯一差异就是它将后台状态全部设置为了true。现在可以用一个新的DaemonThreadFactory作为参数
* 传递给Executor.newCachedThreadPool(): DaemonFromFactory.java
* */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
