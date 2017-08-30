package com.company.haaphoop.thinkingInJava.chapter17;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;
import com.company.haaphoop.thinkingInJava.chapter16.CountingGenerator;
import com.company.haaphoop.thinkingInJava.chapter16.RandomGenerator;

import java.util.Iterator;

public class Letters implements Generator<Pair<Integer, String>>,
        Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

   /* public Pair<Integer, String> next() {
        return new Pair<Integer, String>(
                number++, ""+letter++
        );
    }*/

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(
                number++, "" + letter++
        );
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

class MapDateTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));

        System.out.println(MapData.map(new CountingGenerator.Character(), new
                RandomGenerator.String(3), 8));

        System.out.println(MapData.map(new CountingGenerator.Character(),
                "Valud", 6));

        System.out.println(MapData.map(new Letters(), new RandomGenerator
                .String(3)));

        System.out.println(MapData.map(new Letters(), "Pop"));
    }
}
