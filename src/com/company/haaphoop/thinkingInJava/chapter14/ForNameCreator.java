package com.company.haaphoop.thinkingInJava.chapter14;

import java.util.*;

/**
 * Created by daishuli on 2017/7/26.
 */
public class ForNameCreator extends PetCreator{
    private static List<Class<? extends  Pet>> types =
            new ArrayList<Class<? extends Pet>>();
    private static String[] typeNames = {
            "com.company.haaphoop.thinkingInJava.chapter14.Mutt",
            "com.company.haaphoop.thinkingInJava.chapter14.Pug",
            "com.company.haaphoop.thinkingInJava.chapter14.EgyptianMau",
            "com.company.haaphoop.thinkingInJava.chapter14.Manx",
            "com.company.haaphoop.thinkingInJava.chapter14.Cymric",
            "com.company.haaphoop.thinkingInJava.chapter14.Mouse",
            "com.company.haaphoop.thinkingInJava.chapter14.Pet",
            "com.company.haaphoop.thinkingInJava.chapter14.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public List<Class<? extends Pet>> types(){return types;};
}

class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter count = new PetCounter();
        for (Pet pet : creator.createArray(20)) {

            System.out.println(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                count.count("Pet");
            }

            if (pet instanceof Dog) {
                count.count("Dog");
            }

            if (pet instanceof Mutt) {
                count.count("Mutt");
            }

            if (pet instanceof Pug) {
                count.count("Pug");
            }

            if (pet instanceof Cat) {
                count.count("Cat");
            }

            if (pet instanceof Manx) {
                count.count("Manx");
            }

            if (pet instanceof Cymric) {
                count.count("Cymric");
            }

            if (pet instanceof Rodent) {
                count.count("Rodent");
            }

            if (pet instanceof Rat) {
                count.count("Rat");
            }

            if (pet instanceof Mouse) {
                count.count("Mouse");
            }

            if (pet instanceof Hamster) {
                count.count("Hamster");
            }
        }

        System.out.println();
        System.out.println(count);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}

class Individual {
    public Individual() {}
    public Individual(String name){System.out.println(name);}
}

class Person extends Individual{
    public Person() {super();}
    public Person(String name) {super(name);}
}

class Pet  extends Individual{
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




