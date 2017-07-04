package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/4.
 */
public interface ClassInterface {
    void howdy();
    class Test implements ClassInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            Test test = new Test();
            test.howdy();
        }
    }

}
