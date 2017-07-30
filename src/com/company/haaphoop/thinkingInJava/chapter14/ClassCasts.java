package com.company.haaphoop.thinkingInJava.chapter14;

public class ClassCasts {
    /*
    * cast()方法接受参数对象，并将其转型为Class引用的类型。
    * */
    public static void main(String[] args) {
        Building building = new House();
        building.print();
        //Class<House> houseType = House.class;
        House h = House.class.cast(building);
        if (building instanceof House) {
            House house = (House)building;
        }
        //House h = (House)building;
        h.print();
    }
}

class Building {
    void print(){
        System.out.println(this);
    }
}
class House extends Building{
    void print1(){
        System.out.println(this + "001");
    }
}