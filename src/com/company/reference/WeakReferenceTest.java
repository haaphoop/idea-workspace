package com.company.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by daishuli on 2018/4/26.
 */
public class WeakReferenceTest {
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
                System.out.println("Object for WeakReference is "+obj.get());
            }
        }
    }

    public static void main(String[] args)
    {
        MyObject object = new MyObject();
        Reference<MyObject> weakRef = new WeakReference<>(object,queue);
        System.out.println("创建的弱引用为："+weakRef);
        new Thread(new CheckRefQueue()).start();

        object = null;

        System.out.println("Before GC: Weak Get= "+weakRef.get());
        //System.gc();
        byte[] b = new byte[5*1024*680];
        System.out.println("After GC: Weak Get= "+weakRef.get());
    }
}
