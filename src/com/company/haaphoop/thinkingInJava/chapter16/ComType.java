package com.company.haaphoop.thinkingInJava.chapter16;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ComType implements Comparable<ComType> {
    int i;
    int j;
    private static int count = 1;

    public ComType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(ComType o) {
        return (i < o.i ? -1 : (i == o.i ? 0 : 1));
    }

    private static Random random = new Random(47);

    public static Generator<ComType> generator() {
        return new Generator<ComType>() {
            @Override
            public ComType next() {
                return new ComType(random.nextInt(100), random.nextInt(100));
            }
        };
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j;
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        ComType[] a = Generated.array(new ComType[12], generator());
       /* ComType[] a = {new ComType(0,1), new ComType(-1,1),new ComType
                (2,1), new ComType(-2,1)};*/
  /*      System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));*/

        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }

    /*
    * 在定义作比较的方法时，由你负责决定将你的一个对象与另一个对象作比较的含义。这里在比较中只用到了i值，而忽略了j值。
    *  generator()方法生成一个对象，此对象通过创建一个匿名内部类来实现Generator接口。该例中构建ComType
    *  对象，并使用随机数加以初始化。在main()中，使用生成器填充ComType的数组，然后对其排序。如果没有实现Comparable接口，调用
    *  sort()的时候会抛出ClassCastException这个运行时异常。因为sort()需要把参数的类型转变为Comparable。
    *  假设有人给你一个并没有实现Comparable的类，或者给你的类实习那了Comparable，但是你不喜欢它的实现方式，你需要另外一种不同的
    *  比较方式。要解决这个问题，可以创建一个实现了Comparator接口的单独的类。这是策略设计模式的一个应用实例。这个类由compare()
    *  和equals()两个方法。然而，不一定要实现equals()方法，除非有特殊的性能需要，因为无论何时创建一个类，都是简介继承自Object,
    *  而Object带有equals()方法。所以只需用默认的Object的equals()方法就可以满足接口的要求了。
    *  Collections类包含一个reverseOrder()
    *  方法，该方法可以产生一个Comparator，它可以反转自然的排序顺序。这很容易应用与ComType.
    *       当然也可以编写自己的Comparator。在这里ComType对象是基于j值而不是基于i值的。
    *
    * */
}
