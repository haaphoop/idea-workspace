package com.company.haaphoop.thinkingInJava.chapter14;

import java.util.Arrays;
import java.util.List;

/**
 * Created by daishuli on 2017/7/25.
 */


public class Circle extends Shape{
    @Override
    public String toString() {
        return "Circle{}";
    }
    /*
    * 在这个例子中的Shape接口中动态绑定了draw()方法，目的就是让客户端程序员使用泛化的Shape引用来调用draw()。draw()在所有派生类里都会被覆盖，并且由于它是被动态绑定的，所以即使是通过泛化的Shape引用来调用，也能产生正确行为。这就是多态。
    * 因此，通常会创建一个具体对象，把它向上转型成Shape（忽略对象的具体类型），并在后面的程序中使用匿名的Shape引用。
    * */
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        /*ArrayList<Shape> shapeList = new ArrayList<Shape>();
        shapeList.add(new Circle());
        shapeList.add(new Square());
        shapeList.add(new Triangle());*/
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
    /*
    * 基类中包含draw()方法，它通过传递this参数给System.out.println()，间接地使用toString()打印类标识符（注意，toString()被声明为abstract,以此强制继承者覆写该方法，并可以防止对无格式的Shape的实例化）。如果某个对象出现在字符串表达式中（涉及“+”和字符串对象的表达式），toString()方法就会被自动调用，以生成表示该对象的String。每个派生类都要覆盖（从Object继承来的）toString()方法，这样draw()在不同情况下就打印初不同的消息（多态）。
    * 在这个例子中，当把Shape对象放入List<Shape>的数组时会向上转型。但在向上转型为Shape的时候也丢失了Shape对象的具体类型。对于数组而言，它们知识Shape类的对象。
    * 当从数组中取出元素时，这种容器-----实际上它将所有的事物都当作Object持有-----会自动将结果转型回Shape。这是RTTI最基本的使用形式，因为在Java中，所有的类型转换都是在运行时进行正确检查的。这也是RTTI名字的含义：在运行时，识别一个对象的类型。
    * 在这个例子中，RTTI类型转换并不彻底：Object被转型为Shape，而不是Circle、Square或者Triangle。这是因为目前我们只知道List<Shape>保存的都是Shape。在编译时，将由容器和Java的泛型系统来强制确保这一点；而在运行时，由类型转换操作来确保这一点。
    * 多态机制保证了Shape对象实际执行什么样的代码，由引用所指向的具体对象决定的。
    *
    * */
}

abstract class Shape{
    void draw(){System.out.println(this + ".draw()");}
    abstract public String toString();
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square{}";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle{}";
    }
}