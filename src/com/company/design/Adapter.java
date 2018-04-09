package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class Adapter extends Source implements Target {
    @Override
    public void request() {
        super.doSomething();
    }
}
