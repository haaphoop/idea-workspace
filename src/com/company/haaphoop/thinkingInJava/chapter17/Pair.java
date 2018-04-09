package com.company.haaphoop.thinkingInJava.chapter17;

/*
* key和valud域都是public和final的，这是为了使Pair成为只读的数据传输对象。
* */
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
