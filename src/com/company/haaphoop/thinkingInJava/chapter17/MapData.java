package com.company.haaphoop.thinkingInJava.chapter17;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.LinkedHashMap;

/*
* 这给了一个机会，去选择使用单一的Generator<Pair<K,
* V>>、两个分离的Generator、一个Generator和一个常量值、一个Iterable(包括任何Collection)
* 和一个Generator,还是一个Iterable和一个单一值。泛型便利方法可以减少在创建MapData类时所必需的类型检查数量。
* 下面是一个使用MapData的示例。LettersGenerator通过产生一个Iterator还实现了Iterable
* ，通过这种方式，它可以被用来测试MapData.map()方法，而这些方法都需要用到Iterable:Letters.java
* */
public class MapData<K, V> extends LinkedHashMap<K, V> {
    // a single Pair Generator
    public MapData(Generator<Pair<K, V>> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> pair = generator.next();
            put(pair.key, pair.value);
        }
    }

    // two separate Generators
    public MapData(Generator<K> generatorK, Generator<V> generatorV, int
                   quantity) {
        for (int i = 0; i < quantity; i++) {
            put(generatorK.next(), generatorV.next());
        }
    }

    // a key Generator and a single value
    public MapData(Generator<K> generator, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(generator.next(), value);
        }
    }

    // an Iteratble and a value Generator
    public MapData(Iterable<K> iterable, Generator<V> generator) {
        for (K key: iterable) {
            put(key, generator.next());
        }
    }

    // an Iterable and a single value
    public MapData(Iterable<K> iterable, V value) {
        for (K key: iterable) {
            put(key, value);
        }
    }

    // Generic convenience methods
    public static <K,V> MapData<K, V> map(Generator<Pair<K, V>> generator,
                                          int quantity){
        return new MapData<K, V>(generator, quantity);
    }

    public static <K,V> MapData<K, V> map(Generator<K> generator
            , Generator<V> generatorV, int
                                          quantity){
        return new MapData<K, V>(generator,generatorV, quantity);
    }

    public static <K,V> MapData<K, V> map(Generator<K> generator,
                                          V value, int quantity){
        return new MapData<K, V>(generator,value, quantity);
    }

    public static <K,V> MapData<K, V> map(Iterable<K> generator,
                                               Generator<V> generatorV){
        return new MapData<K, V>(generator, generatorV);
    }

    public static <K,V> MapData<K, V> map(Iterable<K> generator,
                                         V generatorV){
        return new MapData<K, V>(generator, generatorV);
    }
}
