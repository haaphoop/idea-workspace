package com.company.reference;

import sun.misc.JavaLangAccess;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by daishuli on 2018/4/26.
 */
public class PhantomRefTest {
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

    public static class CheckRefQueue implements Runnable
    {
        Reference<MyObject> obj = null;
        @Override
        public void run()
        {
            try
            {
                obj = (Reference<MyObject>)queue.remove();
                System.out.println("删除的虚引用为："+obj+"  but获取虚引用的对象obj.get()="+obj.get());
                System.exit(0);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyObject object = new MyObject();
        Reference<MyObject> phantom = new PhantomReference<MyObject>(object, queue);
        System.out.println("创建的虚引用为："+phantom);
        new Thread(new CheckRefQueue()).start();

        object = null;
        TimeUnit.SECONDS.sleep(1);
        int i = 1;
        while(true)
        {
            System.out.println("第"+i+++"次gc");
            System.gc();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
