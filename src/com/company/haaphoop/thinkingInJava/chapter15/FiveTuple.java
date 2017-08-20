package com.company.haaphoop.thinkingInJava.chapter15;

public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D>{
    public final E five;

    public FiveTuple(A first, B second, C third, D fourth, E five) {
        super(first, second, third, fourth);
        this.five = five;
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "five=" + five +
                ", fourth=" + fourth +
                ", third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
