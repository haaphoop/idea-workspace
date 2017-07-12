package com.company.haaphoop.thinkingInJava.chapter13;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/12 21:35
 * @Modified:
 */
public class Concatenation {
    /*
    *
    * 可以想像一下，这段代码是这样工作的：String可能有一个append()方法，它会生成一个新的String对象，以包含“abc”与mango
    * 连接后的字符串。然后，该对象再与"def"相连，生成另一个新的String对象，以此类推。
    * 这种工作方式当然也行得通，但是为了生成最终的String，此方法会产生一大堆需要垃圾回收的中间对象。
    * 查看JVM字节码，可以看到编译器自动引入了java.lang.StringBuilder类。虽然源代码中没有使用StringBuilder类，但是编译器
    * 却自作主张地使用了它，因为它更高效。
    * 在这个例子中，编译器创建了一个StringBuilder对象，用以构造最终的String,并为每个字符串调用一次StringBuilder的append()方法，
    * 总计四次。最后调用toString()生成结果，并保存为s。
    * 如果预先知道最终的字符串有多长，可以预先指定StringBuilder的大小，避免多次重新分配缓冲。
    *
    * 因此，当你为一个类编写toString()方法时，如果字符串操作比较简单，那就可以信赖编译器，它会为你合理地构造最终的字符串结果。但是
    * 如果你要在toString()方法中使用循环，那么最好自己创建一个StringBuilder对象，用它来构造最终的结果。
    * 如果想走捷径，例如append(a + ":" + c),那么编译器就会调入陷阱，从而为你另外创建一个StringBuilder对象处理括号内的字符串操作。
    * StringBuilder提供了丰富而全面的方法，包括insert()、replace()、substring()、甚至reverse()，但是最常用的还是append()和toString()。
    * 还有delete()方法，上面的例子中我们用它删除最后一个逗号与空格，以便添加右括号。
    * StringBuilder是Java SE5引入的，在这之前Java用的是StringBuffer。后者是线程安全的，因此开销也会大些，所以在Java SE5/6中，字符串操作
    * 应该还会快一点。
    * */
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
