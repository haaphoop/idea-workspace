package com.company.haaphoop.thinkingInJava.chapter13;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/12 20:12
 * @Modified:
 */
public class Immutable {
    /*
    * 当把q传给upcase()方法时，实际传递的是引用的一个拷贝。其实，每当把String对象作为方法的参数时，都会复制一份引用，而
    * 该引用所指的对象其实一直待在单一的物理位置上，从未动过。
    * */
    public static String upcase(String s) {
        if (s != null && s.length() > 0) {
            return s.toUpperCase();
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
