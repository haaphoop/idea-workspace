package com.company.haaphoop.thinkingInJava.chapter19;

import static com.company.haaphoop.thinkingInJava.chapter19.Spiciness.*;

/*
* 使用static import 能够将enum实例的标识符带入当前的命名空间，所以无需再用enum类型来修饰enum实例。
* 这是一个好的想法吗？或者还是显式地修饰enum实例更好？
* */
public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }

    @Override
    public String toString() {
        return "Burrito{" +
                "degree=" + degree +
                '}';
    }
}
