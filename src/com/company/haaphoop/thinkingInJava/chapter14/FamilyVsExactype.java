package com.company.haaphoop.thinkingInJava.chapter14;

/**
 * test()方法使用了两种形式的instanceof 作为参数来执行类型检查。然后获取Class引用，并用== 和equals()来检查
 * class对象是否相等。使人放心的是，instanceof 和isInstance()生成的结果完全一样，equals()和==也一样。但是这两组
 * 测试得出的结论却不相同。instanceof保持了类型的概念，它指的是"你是这个类么？或者你是这个类的派生类么"，而如果用==比较的
 * 实际的Class对象，就没有考虑继承--它或者是这个确切的类型，或者不是。
 */
public class FamilyVsExactype {
    static void test(Object x) {
        System.out.println("Testing x of type :" + x.getClass());
        System.out.println("x instanceof Base1 :" + (x instanceof Base1));
        System.out.println("x instanceof Derived :" + (x instanceof Derived));
        System.out.println("Base1.isInstance(x) :" + Base1.class.isInstance
                (x) );
        System.out.println("Derived.isInstance(x) :" + Derived.class
                .isInstance(x));
        System.out.println("x.getClass() == Base1.class:" + (x.getClass() ==
                Base1.class));
        System.out.println("x.getClass() == Derived.class:" + (x.getClass() ==
                Derived.class));
        System.out.println("x.getClass.equals(Base1.class) :" + x.getClass()
                .equals(Base1.class));
        System.out.println("x.getClass.equals(Derived.class) :" + x.getClass()
                .equals(Derived.class));
    }

    public static void main(String[] args) {
        test(new Base1());
        test(new Derived());
    }
}

class Base1 {}

class Derived extends Base1 {}
