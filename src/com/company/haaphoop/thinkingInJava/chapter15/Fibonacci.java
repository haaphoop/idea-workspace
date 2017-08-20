package com.company.haaphoop.thinkingInJava.chapter15;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        } else {
            return fib(n - 2) + fib(n - 1);
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(fibonacci.getCount() + "   " + fibonacci.next
                    () + " " +
                    fibonacci.getCount());
        }
    }
}
