package com.company.haaphoop.thinkingInJava.chapter14;

import java.util.ArrayList;
import java.util.List;

public class GenericClassReferences {
    /*
    * 普通的类引用不会产生警告信息，可以看到，尽管泛型类引用只能赋值为指向其声明的类型，但是普通的类引用
    * 可以被重新赋值为指向任何其他的Class对象。通过使用泛型语法，可以让编译器强制
    * 执行额外的类型检查。
    * */
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.TYPE;
        intClass = double.class;

    }
}

class WildcardClassReferences {
    /*
    * 为了在使用泛化的Class引用时放松限制，使用？通配符，是Java泛型的一部分。通配符
    * 表示任何事物。Class<?>优于平凡的Class，即便它们是等价的，并且平凡的Class如你所见，不会
    * 产生编译器警告错误。Class<?>的好处是它表示你并非是碰巧或者由于疏忽，而使用了一个
    * 非具体的引用。
    * 为了创建一个Class引用，它被限定为某种类型，或该类型的任何子类型，你需要将通配符
    * 与extends关键字相结合，创建一个范围。
    * */
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}

class BoundedClassReferences {
    /*
    * 向Class引用添加泛型语法的原因仅仅是为了提供编译期类型检查，因此如果操作有误，稍后
    * 立即就会发现这一点。
    * */
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}

class CountedInteger {
    public static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    /*
    * 这个类必须假设与它一同工作的任何类型都具有哦一个默认的构造器（无参构造器），
    * 否则将抛出异常
    * */
    public static void main(String[] args) {
        FilledList<CountedInteger> filledList = new
                FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(filledList.create(15));
        System.out.println(CountedInteger.counter);
    }
}

class GenericToyTest {
    /*
    * 当将泛型语法用于Class对象时，会发生一件很有趣的事情：newInstance()将返回该对象的
    * 确切类型，而不仅仅只是在ToyTest.java中看到的基本的Object。
    * 如果你手头的是超类，那编译器将只允许你声明超类引用是"某个类，他是FancyToy超类"，
    *
    * */
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        Class ftClass1 = FancyToy.class;
        //Object fancyToy1 = ftClass1.newInstance();
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
