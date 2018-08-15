package com.company;

public class Student extends Person {

    @Override
    public void print() {
        System.out.println("this is student");
    }

    public void print(String arg) {
        System.out.println(arg);
    }

    public static void main(String[] args) {
        Person person = new Student();
        person.print();

    }
}
