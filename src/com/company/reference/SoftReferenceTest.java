package com.company.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by daishuli on 2018/4/26.
 */
public class SoftReferenceTest {
    private static ReferenceQueue<MyObject> queue = new ReferenceQueue<MyObject>();
    public static class MyObject {
        @Override
        public String toString() {
            return "I am MyObject";
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("MyObject's finalize called");
        }
    }

    public static class CheckRefQueue implements Runnable {
        Reference<MyObject> obj = null;
        @Override
        public void run() {
            try {
                obj = (Reference<MyObject>)queue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(obj);
            if (obj != null) {
                System.out.println("Object for SoftReference is "+obj.get());
            }
        }
    }

    public static void main(String[] args) {
        MyObject object = new MyObject();
        SoftReference<MyObject> softReference = new SoftReference<MyObject>(object, queue);

        new Thread(new CheckRefQueue()).start();
        object = null;
        System.gc();
        System.out.println("After GC: Soft Get= "+softReference.get());
        System.out.println("分配大块内存");
        byte[] b = new byte[5*1024*680];
        System.out.println("After new byte[]:Soft Get= "+softReference.get());
        System.gc();
    }
}
