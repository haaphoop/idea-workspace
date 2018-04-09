package com.company.haaphoop.thinkingInJava.chapter21;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    /*
    * 一旦main()完成其工作，就没什么能阻止程序中止了，因为除了后台线程之外，已经没有线程在运行了。main()线程
    * 被设定为短暂睡眠，所以可以观察到所有后台线程启动后的结果。不这样的话，就只能看见一些后台线程创建时得到的结果（
    * 试试调整sleep()休眠的时间，以观察这个行为）。
    * */
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            //必须在线程启动之前调用setDaemon()方法，才能把它设置为后台线程
            daemon.setDaemon(true);
            daemon.start();
        }

        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
