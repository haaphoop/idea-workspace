package com.company.haaphoop.thinkingInJava.chapter10;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by daishuli on 2017/7/4.
 */
public class Parcel11 {
    /*
    * 在main()方法中，没有任何Parcel11对象时必需的，而是使用选取static成员的普通语法来调用方法---这些方法返回对Contents和
    * Destination的引用。就像在本章前面看到的那样，在一个普通的(非static)内部类中，通过一个特殊的this引用可以链接到其外围
    * 对象。嵌套类就没有这个特殊的this引用，这使得它类似于一个static方法。
    *
    * */
    private static class ParcelContents implements Contents {
        private int i = 11;
        public int value(){return i;}
    }

    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }

        public static void f(){}

        static int x = 10;
        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String s){
        return new ParcelDestination(s);
    }

    public static Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("daishuli");
        System.out.println(contents.value());
        System.out.println(destination.readLabel());
    }
}
