package com.company.haaphoop.thinkingInJava.chapter16;

public class ArrayOfGenericType<T> {
    T[] array;

    public ArrayOfGenericType(int size) {
        //array = new T[size];
        array = (T[])new Object[size];
    }
}
