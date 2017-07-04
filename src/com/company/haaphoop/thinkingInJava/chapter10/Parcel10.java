package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/4.
 */
public class Parcel10 {
    /*
    * 在实例初始化操作得内部，可以看到有一段代码，它们不能作为字段初始化动作得一部分来执行。所以对于匿名类而言，实例初始化
    * 得实际效果就是构造器。当然它受到了限制---你不能重载实例初始化代码，所以你仅有一个这样得构造器。
    * */
    public Destination destination(final String dest, final float price){
        return new Destination() {
            private int coast;
            {
                coast = Math.round(price);
                if (coast > 100) {
                    System.out.println("Over budget!");
                }
            }
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination destination = parcel10.destination("daishuli",101.95f);
        System.out.println(destination.readLabel());
    }
}
