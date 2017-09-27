package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.ArrayList;
import java.util.concurrent.*;
/*
* submit()方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。可以用isDone()方法来查询
* Future是否已经完成。当任务完成时，它具有一个结果，你可以调用get()方法来获取该结果。你也可以不用isDone()进行检查
* 就直接调用get()，在这种情况下，get()将阻塞，直至结果准备就绪。你还可以在试图调用get()来获取结果之前，先调用具有
* 超时的get()，或者调用isDone()来查看任务是否完成。
* */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> future : results) {
            try{
                System.out.println(future.get());
            } catch (InterruptedException e){
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}
