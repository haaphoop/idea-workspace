package com.company.haaphoop.thinkingInJava.chapter9;

/**
 * Created by daishuli on 2017/6/27.
 */
public abstract class Instrument {
    private int i; // Storage allocated for each
    public abstract void play();
    public String what() {return "Instrument";}
    public abstract void adjust();
}