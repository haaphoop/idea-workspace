package com.company.haaphoop.thinkingInJava.chapter16;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionData<T> {

    private Generator<T> generator;
    int size;
    ArrayList<T> collection;

    public CollectionData(Generator<T> generator, int size) {
        this.generator = generator;
        this.size = size;
        collection = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            collection.add(generator.next());
        }
    }

    public T[] toArray(T[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = collection.get(i);
        }
        return a;
    }
}
