package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/4.
 */
public class Parcel9 {
    /*
    * 在匿名类中定义字段时，还能够对其执行初始化操作
    * 如果定义一个匿名内部类，并且希望它使用一个在其外部定义得对象，那么编译器会要求其参数引用是final的，就像你在destination()
    * 的参数中看到的那样。如果你忘记了，将会得到一个编译时的错误消息。
    * 如果只是简单地给一个字段赋值，那么此例中的方法时很好的。但是，如果想做一些类似构造器的行为，该怎么办呢？在匿名类中不可能有构造器。
    * 但通过实例初始化，就能够达到为匿名内部类创建一个构造器的效果。
    *
    *
    *
    * */
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination destination = parcel9.destination("desy");
        System.out.println(destination.readLabel());
    }
}
