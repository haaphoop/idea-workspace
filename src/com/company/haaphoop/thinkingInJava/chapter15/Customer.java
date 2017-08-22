package com.company.haaphoop.thinkingInJava.chapter15;

import java.util.*;

public class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer(){}

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + '}';
    }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller(){}

    @Override
    public String toString() {
        return "Teller{" + "id=" + id + '}';
    }

    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}

class BankTeller {
    public static void serve(Teller teller, Customer customer) {
        System.out.println(teller + " serve " + customer);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<Customer>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers, Teller.generator(), 4);
        for (Customer customer: line) {
            serve(tellers.get(random.nextInt(tellers.size())), customer);
        }
    }
}