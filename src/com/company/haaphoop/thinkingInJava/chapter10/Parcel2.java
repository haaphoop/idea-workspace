package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/6/29 22:14
 * @Modified:
 */
public class Parcel2 {
    class Contents {
        private int i = 11;
        public int value(){return i;}
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }
    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents(){
        return  new Parcel2.Contents();
    }

    public void ship(String dest) {
        Contents contents = contents();
        Destination destination = to(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 parcel2 = new Parcel2();
        parcel2.ship("Tasmina");
        Parcel2 parcel21 = new Parcel2();
        Parcel2.Contents contents = parcel21.contents();
        Parcel2.Destination destination = parcel21.to("Borneo");
    }
}
