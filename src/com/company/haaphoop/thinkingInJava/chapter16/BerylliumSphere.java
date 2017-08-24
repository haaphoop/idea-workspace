package com.company.haaphoop.thinkingInJava.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "BerylliumSphere{" + "id=" + id + '}';
    }
}

class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }

        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);
        List<BerylliumSphere> list = new ArrayList<BerylliumSphere>();
        for (int i = 0; i < 5; i++) {
            list.add(new BerylliumSphere());
        }

        System.out.println(list);
        System.out.println(list.get(4));
        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);
        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(0,
                1, 2, 3, 4, 5));
        integerList.add(9);
        System.out.println(integerList);
        System.out.println(integerList.get(4));
    }
}
