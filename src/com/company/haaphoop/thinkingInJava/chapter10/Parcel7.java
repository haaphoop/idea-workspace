package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/3.
 */
public class Parcel7 {
    /*
    * 匿名内部类
    * contents()方法将返回值的生成与表示这个返回值的类的定义结合在一起！另外，这个类是匿名的，它没有名字。更糟的是，看起来
    * 似乎是你正要创建一个contents对象。但是然后你却说：“等一等，我想在这里插入一个类的定义。”。这种奇怪的语法指的是“创建
    * 一个继承自Contents的匿名的对象。”，通过new表达式返回的引用被自动向上转型为对Contents的引用。
    * */
    public Contents contents(){
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 parcel7 = new Parcel7();
        Contents contents = parcel7.contents();
        System.out.println(contents.value());
    }
}
