package com.company.haaphoop.thinkingInJava.chapter19;

public enum  Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }

    public Food randomSelector() {
        return Enums.random(values);
    }

    /*
    * 在上面的程序中，每一个Coure的实例都将其对应的Class对象作为构造器的参数。通过getEnumConstants()方法，可以从该
    * class对象中取得某个Food子类的所有enum实例。这些实例在randomSelector()
    * 中被用到。因此，通过从每一个Course实例中随机地选择一个Food，我们便能够生成一份菜单:Meal.java
    * */
}

class Meal {
    /*
    * 在这个例子中，通过遍历每一个Course实例来获得“枚举的枚举”的值。稍后，在VendingMachine,java中，我们会看到另一种
    * 组织枚举实例的方式，但其也有一些其他的限制。
    * 此外，还有一种更简洁的管理枚举的办法，就是将一个enum嵌套在另一个enum内。就像这样：SecurityCategory.java
    * */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelector();
                System.out.println(food);
            }
            System.out.println("=======");
        }
    }
}
