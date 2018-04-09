package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 非常常见的情况是，单个的Executor被用来创建和管理系统中所有的任务。
* 对shutdown()方法的调用可以防止新任务被提交给这个Executor，当前线程（本例中，即驱动main()的线程）将继续运行在shutdown
* ()被调用之前提交的所有任务。这个程序将在Executor中的所有任务完成之后尽快退出。
*   可以很容易地将前面示例中的CachedThreadPool替换为不同类型的Executor。FixedThreadPool
*   .java使用了有限的线程集来执行所提交的任务：FixedThreadPool.java
* */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
