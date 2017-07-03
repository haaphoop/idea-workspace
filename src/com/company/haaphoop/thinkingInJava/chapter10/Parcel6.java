package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/3.
 */
public class Parcel6 {
    /*
    * 下面的例子展示了如何在任意的作用域内嵌入一个内部类
    * */
    private void internalTracking(boolean b){
        if (b){
            class TrackingShip {
                private String id;
                TrackingShip(String s){
                    id = s;
                }
                String getSlip(){return id;}
            }
            TrackingShip trackingShip = new TrackingShip("slip");
            String s = trackingShip.getSlip();
            System.out.println(s);
        }
    }
    /*
    * TrackingSlip类被嵌入在if语句块内，这并不是说该类的创建是有条件的，它其实与别的类一起编译过了。然而，在定义TrackingSlip
    * 的作用域之外，它是不可用的；除此之外，它与普通的类一样。
    * */
    public void track(){internalTracking(true);}

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
