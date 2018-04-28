package com.company.threadlocal;

/**
 * Created by daishuli on 2018/4/28.
 */
public class SequenceNumber {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public int getNextNum() {
        threadLocal.set(threadLocal.get()+1);
        return threadLocal.get();
    }
}
