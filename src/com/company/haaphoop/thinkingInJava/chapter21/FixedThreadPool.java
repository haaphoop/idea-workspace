package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 有了FixedThreadPool，就可以一次性预先执行代价高昂的线程分配，因而也就可以限制线程的数量了。这可以节省时间，
* 因为不用为每个任务都固定地付出创建线程的开销。在事件驱动的系统中，需要线程的事件处理器，通过直接从池中获取线程，
* 也可以如你所愿地尽快得到服务。
* */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
