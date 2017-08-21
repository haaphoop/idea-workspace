package com.company.haaphoop.thinkingInJava.chapter15;

/*
* 这个类提供了一个基本实现，用以生成某个类的对象。这个类必需具备两个特点：1 它必须声明为public。（因为BasicGenerator与
* 要处理的类在不同的包中，所以该类必须声明为public，并且不只具有包内访问权限。） 2 它必须具备默认的构造器（无参数的构造器）。
* 要创建这样的BasicGenerator对象，只需调用ctreate()方法，并传入想要生成的类型。泛型化的create()
* 方法允许执行BasicGenerator,create(MyType.class),而不必执行麻烦的new
* BasicGenerator<MyType>.create(MyType.class)。
* BasicGenerator<MyType>(MyType.class)。
* */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type) {
        this.type = type;
    }


    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}
