package com.company.haaphoop.thinkingInJava.chapter12;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/11 22:43
 * @Modified:
 */
public class InheritingException {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

class SimpleException extends Exception {}
