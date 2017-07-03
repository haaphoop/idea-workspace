package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/3.
 */
public class Parcel8 {
    /*
    * 这个例子展示了，如果你的基类需要一个有参数的构造器，应该怎么办？
    * 只需简单地传递合适的参数给基类的构造器即可，这里是将x传递进new Wrapping(x).尽管Wrapping只是一个具有具体实现的普通类，但它还是
    * 被其导出类当作公共“接口”来使用。你会注意到，Wrapping拥有一个要求传递一个参数的构造器，它使得事情变得更加有趣了。
    * */
    public Wrapping wrapping(int x){
        return new Wrapping(x){

            public int value() {
                /*调用原类中的方法，需要用super关键字，与类的继承关系一样
                * 被当作接口来使用，由parcel8.wrapping()方法创建的Wrapping类调用的value()方法，实际上是在这里定义的。
                * */
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(10);
        System.out.println(wrapping.value());
    }
}

class Wrapping {
    private int i;
    public Wrapping(int x){ i = x;}
    public int value(){return i;}
}
