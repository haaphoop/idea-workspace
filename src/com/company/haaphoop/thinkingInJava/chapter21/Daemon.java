package com.company.haaphoop.thinkingInJava.chapter21;

class Daemon1 implements Runnable {
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
        }

        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "started. ");
        }
        while (true)
            Thread.yield();
    }

    public static void main(String[] args) {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println();
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
