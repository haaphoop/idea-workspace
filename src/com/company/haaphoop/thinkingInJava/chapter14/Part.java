package com.company.haaphoop.thinkingInJava.chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
*
* 基类Part包含一个工厂对象的列表。对于应这个由createRandom()方法产生的类型，它们的工厂
* 都被添加到了partFactories List中，从而被注册到了基类中。
* 并非所有在继承结构中的类都应该被实例化，在本例中，Filter和Belt只是分类标识，因此你不应该创建它们的实例，而只应该创建它们的
* 子类的实例。如果某个类应该由createRandom()方法创建，那么它就包含一个内部Factory类。如例所示，重用名字Factory的唯一方式
* 就是限定Factory。尽管可以使用Collections.addAll()来向列表中添加工厂，但是这样做编译器就会表达它的不满，抛出一条
* 有关"创建泛型数组"（这被认为是不可能的）。createRandom()
* 方法从partFactories中随机地选取一个工厂对象，然后调用其cteate()方法，从而产生一个新的Part。
* */
public class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random random = new Random(47);

    public static Part createRandom() {
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements com.company.haaphoop
            .thinkingInJava.chapter14.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements com.company.haaphoop
            .thinkingInJava.chapter14.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements com.company.haaphoop
            .thinkingInJava.chapter14.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements com.company.haaphoop
            .thinkingInJava.chapter14.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements com.company.haaphoop
            .thinkingInJava.chapter14.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements com.company.haaphoop
            .thinkingInJava.chapter14.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements com.company.haaphoop
            .thinkingInJava.chapter14.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}