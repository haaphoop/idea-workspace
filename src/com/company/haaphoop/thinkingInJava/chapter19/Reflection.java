package com.company.haaphoop.thinkingInJava.chapter19;

import com.company.haaphoop.thinkingInJava.chapter18.OSExcute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/*
* 可以看出valus()方法是由编译器添加的static方法。可以看出，在创建Explore的过程中，编译器还为其添加了valueof()方法。这
* 可能令人迷惑，Enum类不是已经有valudOf()方法了吗。不过Enum中的valueOf()
* 方法需要两个参数，而这个新增的方法只需要一个参数。由于这里使用的Set只存储方法的名字，而不考虑方法的签名，所以在调用Explore
* .removeAll(Enum)之后，就只剩下values。
*   从最后的输出中可以看到，编译器将Explore标记为final类，所以无法继承自enum。其中还有一个static
*   的初始化子句，稍后将学习如何重定义该句。
*
*   由于values()方法是由编译器插入到enum定义中的static方法，所以如果将enum实例向上转型为enum，那么values()方法就不可访问。
*   不过，在Class中有一个getEnumConstants()方法，所以即便Enum接口中没有values()
*   方法，仍可以通过Class对象取得所有enum实例：UpcastEnum.java
* */
public class Reflection {
    public Reflection() {
    }

    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("---Analyz " + enumClass + " ----------------");
        System.out.println("Interfaces");
        for (Type type : enumClass.getInterfaces()) {
            System.out.println(type);
        }

        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method method: enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.contailsAll(Enum)? " + exploreMethods
                .containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        OSExcute.command("java= Explore");
    }
}

enum Explore {
    HERE, THERE
}
