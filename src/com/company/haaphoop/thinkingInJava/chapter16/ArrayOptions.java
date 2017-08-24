package com.company.haaphoop.thinkingInJava.chapter16;

import com.sun.jndi.ldap.Ber;

import java.util.Arrays;

/*
* 数组a是一个尚未初始化的局部变量，在你对它正确地初始化之前，编译器不允许用此引用做任何事情。数组b初始化为指向
* 一个BerylliumSphere引用的数组，但其实并没有BerylliumSphere对象置入数组中。然而，仍然可以询问数组的大小，因此，
* b指向一个合法的对象。这样做有一个小缺点：你无法知道在此数组中确切地有多少元素，因为length只表示数组能够容纳多少元素。
* 也就是说，length是数组的大小，而不是实际保存的元素个数。新生成一个数组对象时，其中所有的引用被自动初始化为null，所以检查
* 其中的引用是否为null，即可知道数组的某个为止是否存有对象。同样，基本类型的数组如果是数值型的，就被自动初始化为0；如果是字符型
* 的，就没自动初始化为0;如果是布尔型的，就被自动初始化为false.
*
* */
public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        System.out.println("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }
        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(),
                new BerylliumSphere()};
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere
                ()};
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);
        int  [] e;
        int [] f = new int[5];
        System.out.println("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93 };
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{1, 2};
        System.out.println("e.length = " + e.length);
    }
}
