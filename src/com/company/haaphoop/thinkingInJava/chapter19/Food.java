package com.company.haaphoop.thinkingInJava.chapter19;

public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINALOO;
    }
    enum Dessert implements Food {
        GELATO;
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }

    /*
    * 对于enum而言，实现接口是使其子类化的唯一办法，所以嵌入在Food中的每个enum都实现了Food接口。现在，下面的程序中，我们可以说
    * "所有东西都是某种类型的Food";
    * */
}

class TypeOfFood {
    /*
    * 如果enum类型实现了Food接口，那么我们就可以将其向上转型为Food，所以上例中的所有东西都是Food。
    * 然而，当你需要与一大堆类型大交道时，接口就不如enum好用了。例如，如果你想创建一个"枚举的枚举"，那么可以创建一个
    * 新的enum，然后用其实例包装Food中的每一个enum类；Course.java
    * */
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Coffee.CAPPUCCINO;
    }
}
