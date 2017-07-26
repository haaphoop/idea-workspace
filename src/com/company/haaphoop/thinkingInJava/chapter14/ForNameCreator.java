package com.company.haaphoop.thinkingInJava.chapter14;

import java.util.*;

/**
 * Created by daishuli on 2017/7/26.
 */
public class ForNameCreator {
}

class Individual {
    public Individual() {}
    public Individual(String name){System.out.println(name);}
}

class Person extends Individual {
    public Person() {super();}
    public Person(String name) {super(name);}
}

class Pet extends Individual {
    public Pet() {super();}
    public Pet(String name) {super(name);}
}

class Dog extends Pet {
    public Dog() {super();}
    public Dog(String name) {super(name);}
}

class Mutt extends Dog {
    public Mutt() {super();}
    public Mutt(String name) {super(name);}
}

class Pug extends Dog {
    public Pug() {super();}
    public Pug(String name) {super(name);}
}

class Cat extends Pet {
    public Cat() {super();}
    public Cat(String name) {super(name);}
}

class EgyptianMau extends Pet {
    public EgyptianMau() {super();}
    public EgyptianMau(String name) {super(name);}
}

class Manx extends Cat {
    public Manx() {super();}
    public Manx(String name) {super(name);}
}

class Cymric extends Manx {
    public Cymric() {super();}
    public Cymric(String name) {super(name);}
}

class Rodent extends Pet {
    public Rodent() {super();}
    public Rodent(String name) {super(name);}
}

class Rat extends Rodent {
    public Rat() {super();}
    public Rat(String name) {super(name);}
}

class Mouse extends Rodent {
    public Mouse() {super();}
    public Mouse(String name) {super(name);}
}

class Hamster extends Rodent {
    public Hamster() {super();}
    public Hamster(String name) {super(name);}
}

abstract class PetCreator {
    private Random random = new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet() {
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}




