package com.company.haaphoop.thinkingInJava.chapter16;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GeneratorsTest {
    /*
    * 这里假设待测试类包含一组嵌套的Generator对象，其中每个都有一个默认构造器（无参构造器）。
    * 反射方法getClasses()可以生成所有的嵌套类，而test()方法可以为这些生成器中的每一个都创建一个实例，然后打印通过调用
    * 10次next()方法而产生的结果。下面是一组使用随机数生成器的Generator。因为Random构造器使用常量进行初始化，所以，每次用这些
    * Generator中的一个来运行程序时，所产生的输出都是可重复的。
    * */
    public static int size = 10;
    public static void test(Class<?> surroundClass) {
        for (Class<?> type : surroundClass.getClasses()) {
            System.out.println(type.getSimpleName() + ": ");
            try {
                Generator<?> g = (Generator<?>)type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.printf(g.next() + " ");

                }
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        //test(CountingGenerator.class);

        //GeneratorsTest.test(RandomGenerator.class);

        //Integer[] i = (Integer[])Array.newInstance(Integer.class, 10);
        //System.out.println(Arrays.toString(i));

        /*
        * 即使数组a被初始化过，其中的那些值也在将其传递给Generated.array()
        * 之后被覆写了，因为这个方法会替换这些值（但是会保证原数组的正确性）。b的初始化展示了如何从无到有地创建填充了元素的数组。
        *
        * 泛型不能用于基本类型，而我们确实想用生成器来填充基本类型数组。为了解决这个问题，我们创建了转换器，
        * 它可以接收任意的包装器对象数组，并将其传换为相应的基本类型数组。如果灭有这个工具，我们就必须为所有的
        * 基本类型，创建特殊的生成器。ConverTo.java
        * */
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));
        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.array(Integer.class, new CountingGenerator
                .Integer(), 15);
        System.out.println(Arrays.toString(b));

    }

}
