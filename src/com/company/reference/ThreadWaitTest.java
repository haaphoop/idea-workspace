package com.company.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ThreadWaitTest {
    private static class Lock {};
    private static Lock lock = new Lock();

    private static final Map<String, String> value = new HashMap<>();

    public String insert(String value) {
        synchronized (lock) {
            this.value.put(value,value);
            System.out.println("insert()");
            lock.notifyAll();
        }
        return value;
    }

    public String print() throws InterruptedException{
        System.out.println("print()1");
        synchronized (lock) {
            for (;;) {
                System.out.println("print()2");
                lock.wait(0);
                System.out.println("print()3");
                if (!this.value.isEmpty()) {
                    System.out.println("print()4");
                    System.out.println(this.value);
                    return "";
                }
                System.out.println("print()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException  {
        ThreadWaitTest obj = new ThreadWaitTest();
        obj.insert("test");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ThreadWaitTest obj = new ThreadWaitTest();
                    obj.print();
                } catch (InterruptedException e) {

                }
            }
        }).start();

        //TimeUnit.SECONDS.sleep(10);
        obj.insert("daidai");
        obj.insert("print");
    }
}
