package com.company.haaphoop.thinkingInJava.chapter15;

public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 47);
    }

    static TwoTuple f2(){ return Tuple.tuple("hi", 47);}
}
