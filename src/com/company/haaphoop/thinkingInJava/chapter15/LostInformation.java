package com.company.haaphoop.thinkingInJava.chapter15;

import com.sun.java.swing.plaf.motif.MotifBorders;

import java.util.*;

public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<Frob>();
        Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long, Double> particle = new Particle<Long, Double>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
        /*
        * 根据JDK文档得描述，Class.getTypeParameters()
        * 将“返回一个TypeVariable
        * 对象数组，表示有泛型声明所声明得类型参数。。。。”这好像是在暗示你可能发现参数类型的信息，
        * 但是，正如你从输出中所看到的，你能够发现的只是用作参数占位符的标识符，这并非有用的信息。
        * 因此，残酷的现实是：在泛型代码内部，无法获得任何有关泛型参数类型的信息。
        *
        * 因此，你可以知道诸如类型参数标识符和泛型类型边界这类的信息----你却无法知道用来创建特定实例的实际的类型参数。
        *
        * Java泛型是使用擦除来实现的，这意味着当你在使用泛型时，任何具体的类型信息都被擦除了，你唯一知道的就是你在使用一个对象。
        * 因此List<String> 和List<Integer>
        *     在运行时事实上是相同的类型。这两种形式都被擦除成它们的"原生"类型，即List。理解擦除以及应该如何处理它，
        *
        * */
    }
}

class Frob {}
class Fnorkle {}
class Quark<Q> {}
class Particle<POSITION, MOMENTUM> {}