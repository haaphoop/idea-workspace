package com.company.haaphoop.thinkingInJava.chapter17;

import com.company.haaphoop.thinkingInJava.chapter16.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGenerator {
    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(
                CollectionData.list(new RandomGenerator.String(9), 10)
        ));

        System.out.println(new HashSet<Integer>(
                new CollectionData<Integer>(10, new RandomGenerator.Integer())
        ));
    }
}
