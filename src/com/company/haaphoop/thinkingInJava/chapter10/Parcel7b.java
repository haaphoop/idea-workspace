package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/3.
 */
public class Parcel7b {
    class MyContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }
    /*
    * 在这个匿名类中，使用了默认的构造器来生成Contents。
    * */
    public Contents contents(){return new MyContents();}
    public static void main(String[] args) {
        Parcel7b parcel7b = new Parcel7b();
        Contents contents = parcel7b.contents();
    }
}
