package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/3.
 */
public class Parcel4 {
    private class PContents implements Contents {
        private int i;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;
        private PDestination(String whereTo){
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination getDestination(String s){
        return new PDestination(s);
    }

    public Contents getContents(){
        return new PContents();
    }

    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.getContents();
        Destination destination = parcel4.getDestination("daishuli");
        System.out.println(contents.value());
        System.out.println(destination.readLabel());
    }
}

interface Destination{
    String readLabel();
}
interface Contents {
    int value();
}
