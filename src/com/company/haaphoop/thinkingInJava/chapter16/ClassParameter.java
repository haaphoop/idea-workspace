package com.company.haaphoop.thinkingInJava.chapter16;

public class ClassParameter<T> {
    public T[] f(T[] arg) {
        if (arg != null) {
            for (T t:arg) {
                System.out.println("t + " + t + " ClassParameter");
            }
        }
        return arg;
    }

    public void h(T[] arg) {
        if (arg != null) {
            for (T t:arg) {
                System.out.println("t + " + t + " ClassParameter");
            }
        }
    }
}

class MethodParamter {
    public static <T> T[] f(T[] arg) {
        if (arg != null) {
            for (T t:arg) {
                System.out.println("t + " + t + " MethodParamter");
            }
            System.out.println();
        }
        return arg;
    }
}

class ParamterizedArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
        ints2 = MethodParamter.f(ints);
        doubles2 = MethodParamter.f(doubles);
        new ClassParameter<Integer>().h(ints);
    }
}