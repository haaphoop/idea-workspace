package com.company.haaphoop.thinkingInJava.chapter15;

import java.util.Iterator;
import java.util.Random;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " +  id;
    }
}

class Latte extends Coffee {}
class Mocha extends Coffee {}
class Cappuccino extends Coffee {}
class Americano extends Coffee {}
class Breve extends Coffee {}

/*
* 参数化的Generator<T>接口确保next()
* 的返回值是参数的类型。CoffeeGenerator同时还实现了Iterable
* 接口，所以它可以在循环语句中使用。不过，它还需要一个"末端哨兵"来判断何时停止，这正是第二个构造器的功能。
* */
class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class,
            Americano.class, Breve.class};
    private static Random random = new Random(47);

    public CoffeeGenerator() {}

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGenerator.next());
        }
        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }

        Iterator<Coffee> iterator = new CoffeeGenerator(6).iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}

