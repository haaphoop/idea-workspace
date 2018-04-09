package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget");
    }
}
