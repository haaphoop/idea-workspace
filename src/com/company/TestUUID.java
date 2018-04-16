package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by daishuli on 2018/4/16.
 */
public class TestUUID {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        List<FutureTask<Set<String>>> futureTaskList = new ArrayList<FutureTask<Set<String>>>();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        /*for (int i = 0; i < 1000; i++) {
            FutureTask<Set<String>> futureTask = new FutureTask<Set<String>>(new GenUUId());
            futureTaskList.add(futureTask);
            pool.submit(futureTask);
        }

        Set<String> set = new HashSet<>();
        for(FutureTask<Set<String>> futureTask:futureTaskList){
            try{
                set.addAll(futureTask.get());//统计结果
            }catch (Exception e){
                //TODO
            }
        }*/

        pool.shutdown();
        /*for (String s: set) {
            System.out.println(s);
        }*/
        long after = System.currentTimeMillis();
        //System.out.println("多线程计算后的结果：" + set.size());
        System.out.println("耗时：" + (after - before));
        Set<String> set = new HashSet<>();
        Random rad=new Random();
        for (int i = 0; i < 1000*1000; i++) {
            DateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String uuid = format.format(new Date().getTime())+new Double(Math.random()*100000).intValue();
            while(uuid.length()<22){
                uuid = uuid + rad.nextInt(100000);
            }
            uuid=uuid.substring(2);
            set.add(uuid);
        }
        before = System.currentTimeMillis();
        System.out.println("耗时：" + (before - after));
        System.out.println("单线程计算后的结果：" + set.size());
        generateIdentifier();
    }

    /**
     *
     * @return
     * @description 生成UUID
     * @version 3.0
     * @author 代树理
     * @update 2017年6月13日 上午10:03:02
     */
    protected static String generateIdentifier(){
        long b = System.currentTimeMillis();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        String uid = "";
        for (int i = 0; i < 10000; i++) {
            uid = date+"00001000"+getTwo()+"00"+seconds+getTwo();
            System.out.println(uid);
        }
        long a = System.currentTimeMillis();
        System.out.println(a-b);
        return uid;
        /*Random rad=new Random();
        String uuid = format.format(new Date().getTime())+new Double(Math.random()*100000).intValue();
        while(uuid.length()<22){
            uuid = uuid + rad.nextInt(10);
        }
        uuid=uuid.substring(2);
        return uuid ;*/
    }

    /**
     * 产生随机的2位数
     * @return
     */
    public static String getTwo(){
        Random rad=new Random();
        String result  = rad.nextInt(100) +"";
        if(result.length()==1){
            result = "0" + result;
        }
        return result;
    }
}
