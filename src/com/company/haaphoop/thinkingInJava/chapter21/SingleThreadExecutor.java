package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* SingleThreadExecutor相当于FixedThreadExecutor(1)
* 假设有大量的线程，那它们运行的任务将使用文件系统。可以用SingleThreadExecutor来运行这些线程，以确保任意时刻在任何线程中
* 都只有唯一的任务在运行。在这种方式中，你不需要在共享资源上处理同步。有时更好的解决方案是在资源上同步，但是SingleThreadExecutor
* 可以让你省去只是为了维持某些事物的原型而进行的各种协调努力。通过序列化任务，可以消除对序列化对象的需求。
* */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
