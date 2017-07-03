package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/3.
 */
public class Parcel5 {
    /*
    * 展示了在方法作用域内创建一个完整的类，称为局部内部类
    *
    * */
   public Destination destination(String s) {
       class PDestination implements Destination {
           private String label;
           private PDestination (String whereTo){
               label = whereTo;
           }
           @Override
           public String readLabel() {
               return label;
           }
       }
       return new PDestination(s);
   }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination destination = parcel5.destination("Daishuli");
    }
    /*
    * PDestination类是destination()方法的一部分，而不是Parcel5的一部分。所以，在destination()之外不能访问PDestination。注意
    * 出现在return语句中的向上转型。返回的是Destination的引用，它是PDestination的基类。当然，在destination中定义了内部类，PDestination
    * 并不意味着一旦destination()方法执行完毕，PDestination就不可用了。
    * 可以在同一个子目录下的任意类中对某个内部类使用类标识符PDestination，这并不会有命名冲突。
    *
    * */
}

