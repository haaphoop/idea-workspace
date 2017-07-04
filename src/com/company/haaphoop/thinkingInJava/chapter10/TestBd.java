package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/4.
 */
public class TestBd {
    public void f(){
        System.out.println("f()");
    }
    public static class Tester {
        public static void main(String[] args) {
            TestBd testBd = new TestBd();
            testBd.f();
        }
    }
}
