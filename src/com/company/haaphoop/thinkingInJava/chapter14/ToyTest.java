package com.company.haaphoop.thinkingInJava.chapter14;

/**
 * Created by daishuli on 2017/7/25.
 */
public class ToyTest {
    /*
    * FancyTest继承自Toy并实习那了HasBatteries、Waterproof和Shoots接口。在main()中，用forName()方法在适当的try语句块中，创建了一个Class引用，并将其初始化为指向FancyToyClass。注意，在传递给forName()的字符串中，你必须使用全限定名。
    * */
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.company.haaphoop.thinkingInJava.chapter14.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        // getSuperclass()查询其直接基类
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Class的newInstance()方法是实现"虚拟构造器"的一种途径，虚拟构造器允许你声明，使用newInstance()来创建的类，必须带有默认的构造器。
            obj = up.newInstance();
        }catch (InstantiationException e){
            System.out.println("Can not instantiate");
        } catch (IllegalAccessException e) {
            System.out.println("Can not access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
class Toy {
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy(){super(1);}
}