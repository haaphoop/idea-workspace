package com.company;

/**
 * Created by daishuli on 2018/4/26.
 */
public class WaitForSpecifiedTimeTest {
    static private class Lock { };
    private Lock lock = new Lock();

    public void sleepFor(long mills) {
        synchronized (lock) {
            long now = System.currentTimeMillis();
            System.out.println("be going to sleep");
            try {
                lock.wait(mills);
            } catch (InterruptedException e) {

            }

            System.out.println("I've slept for "+(System.currentTimeMillis()-now)+" mills!");
        }
    }

    public void startAnotherThread() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(300);
                }catch (InterruptedException e) {

                }

                synchronized (lock) {
                    long now = System.currentTimeMillis();
                    System.out.println("I get the monitor");
                    try {
                        Thread.sleep(5000);
                        //睡一下的目的是推迟5秒释放vitual的锁，5秒的时间已经超过了wait()的等待时间，这样可以看看程序有什么异常行为。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("I hold the monitor for "+(System.currentTimeMillis()-now)+" mills");
                }
            }
        };
        thread.start();
    }

    public static void main(String[] args) {
        WaitForSpecifiedTimeTest test = new WaitForSpecifiedTimeTest();
        test.startAnotherThread();
        test.sleepFor(3000);
    }
}
