package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    /*
    * 对sleep()的调用可以抛出InterruptedException异常，并且可以看到，在run()中被捕获。因为异常不能跨线程传播回
    * main()，所以必须在本地处理所有在任务内部产生的异常。
    * Java SE5引入了更加显式的sleep()版本，作为TimeUnit类的一部分，就像上面示例所示的那样。这个方法允许你指定sleep()延迟的
    * 时间单元，因此可以提供更好的可阅读性。TimeUnit还可以被用来执行转换。
    * */
    public void run() {
        try{
            while (countDown-- > 0) {
                System.out.println(status());
                TimeUnit.MICROSECONDS.sleep(1);
            }
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
