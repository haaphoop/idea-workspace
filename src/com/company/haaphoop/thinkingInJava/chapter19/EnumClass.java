package com.company.haaphoop.thinkingInJava.chapter19;

public class EnumClass {
    /*
    * ordinal()方法返回一个int值，这是每个enum实例在声明时的次序，从0开始。可以使用==来比较enum实例，编译器会自动
    * 为你提供equals()和hashCode()方法。Enum类实现了Comparable接口，所以它具有compareTo()
    * 方法，同时，它还实现了Serializable接口。
    *
    * 如果在enum实例上调用getDeclaringClass()方法，我们就能知道其所属的enum类。
    *
    * name()方法返回enum实例声明时的名字，这与使用toString()方法效果相同。valudOf()是在Enum中定义的static方法，
    * 它根据给定的名字返回相应的enum实例，如果不存在给定名字的实例，将会抛出异常。
    * */
    public static void main(String[] args) {
        for (Shrubbery shrubbery: Shrubbery.values()) {
            System.out.println(shrubbery + " ordinal: " + shrubbery.ordinal());
            System.out.println(shrubbery.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.println(shrubbery.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(shrubbery == Shrubbery.CRAWLING);
            System.out.println(shrubbery.getDeclaringClass());
            System.out.println(shrubbery.name());
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}

enum Shrubbery {
    GROUND,
    CRAWLING,
    HANGING
}