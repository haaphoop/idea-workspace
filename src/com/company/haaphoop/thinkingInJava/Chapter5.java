package com.company.haaphoop.thinkingInJava;

import java.util.Arrays;
import java.util.Random;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/6/20 21:45
 * @Modified:
 */
public class Chapter5 {
    /*
        5.1 用构造器确保初始化
            不接受任何参数的构造器称为默认构造器
        5.2 方法重载
            方法名相同形式参数不同
            5.2.1 区分重载方法
                每个重载方法都必须有独一无二的参数类型列表
            5.2.2 涉及基本类型的重载
                基本类型能从一个较小的类型自动提升至一个较大的类型，可能会造成一定的混淆
                如果传入的数据类型小于方法中形式参数的类型，实际数据类型就会被提升。char类型略有不同，
                如果无法找到恰好接收char参数的方法，就会把char直接提升至int类型。如果传入的实际参数较大，
                就得通过类型转换来窄化转换。
        5.3 默认构造器
            默认构造器是没有参数的-它的作用是创建一个默认对象。如果类中没有构造器，编译器会自动创建一个
            默认构造器。但是如果已经定义了一个构造器（无论是否有参数），编译器就不会自动创建默认构造器

        5.4 this关键字
            在方法内部获得对当前对象的引用。方法内部调用同一个类的另一个方法，不必使用this，编译器会自动添加
            5.4.1 在构造器中调用构造器
                在构造器中，为this添加了参数列表，表示对符合参数列表的某个构造器的明确引用。只可以用this调用
                一个构造器，不能调用多个。必须将构造器调用置于最起始处，否则编译器会报错。
            5.4.2 static 的含义
                static的方法就是没有this的方法。

        5.5 清理：终结处理和垃圾回收
            5.5.4 垃圾回收器如何工作
                    垃圾回收器对于提高对象的创建速度，具有明显的效果。
                    在某些java虚拟机中，堆的实现截然不同：更像一个传送带，每分配一个新对象，它就往前移动一格，意味着
                    对象存储空间的分配速度非常快。java的“堆指针”只是简单的移动到尚未分配的区域。当它工作时，将一面回收空间
                    一面使堆中的对象紧凑排列，这样“堆指针”就可以很容易移动到更靠近传送带的开始处，尽量避免了页面错误。通过
                    垃圾回收器对对象的重新排列，实现了一种高速的有无线空间可供分配的堆模型。
                    引用计数是一种简单但速度很慢的垃圾回收技术。每个对象都含有一个引用计数器，当有引用连接至对象时，
                    引用计数加1。当引用离开作用域或被置为null时，引用计数减1。虽然管理引用计数的开销不大，但这项开销在
                    整个程序生命周期中将持续发生。垃圾回收器会在含有全部对象的列表上进行遍历，当发现某个对象的引用计数为0
                    时，就释放其占用的空间（但是，引用计数模式经常会在计数值变为0时立即释放对象）。这种做法有个缺陷，如果对象之间
                    存在循环引用，可能会出现“对象应该被回收，但引用计数却不为0”的情况。引用计数常用来说明垃圾收集的工作方式
                    ，但似乎从未被应用于任何一种java虚拟机实现中。

                    在一些更快的模式中，垃圾回收器并非基于引用计数技术。它们依据的思想是：对任何“活”的对象，一定能最终追溯
                    到其存活在堆栈或静态存储区之中的引用。这个引用链条可能穿过数个对象的层次。由此，如果从堆栈或静态存储区
                    开始，遍历所有的引用，就能找到所有“活”的对象。对于发现的每个引用，必须追踪它所引用的对象，然后是此对象
                    所包含的所有引用，如此反复进行，直到“根源于堆栈和静态存储区的引用”所形成的网络全部被访问为止。在这种
                    方式下，java虚拟机将采用一种自适应得垃圾回收技术。至于如何处理找到得存活对象，取决于不同得虚拟机实现。有一种
                    做法名叫 停止-复制（stop-and-copy）。先暂停程序得运行，然后将所有存活得对象从当前堆复制到另一个堆，没有被复制
                    得全部是垃圾。当对象被复制到新得堆时，它们是一个挨着一个得，所以新堆保持紧凑排列，可以直接分配空间了。
        5.7 构造器初始化
            可以用构造器进行初始化。在运行时刻，可以调用方法或执行某些动作来确定初值，这为变成带来了更大得灵活性。但要牢记：
            无法阻止自动初始化得进行，它将在构造器被调用之前发生。
            5.7.1 初始化顺序
                在类得内部，变量定义得顺序决定了初始化得顺序。即使变量定义散布于方法定义之间，它们仍旧会在任何方法（包含构造器）
                被调用之前得到初始化。
            5.7.2 静态数据的初始化
                  无论创建多少个对象，静态数据都只占用一份存储区域。static关键字不能用于局部变量，因此它只能作用于域。如果
                  一个域是静态的基本类型域，且也没有对它进行初始化，那么它就会获得基本类型的标准初值。如果它是一个对象引用，
                  那么它的默认初始化值就是null。
                  Bowl类使得看到类的创建，而Table类和CupBoard类在它们的类定义中加入了Bowl类型的静态数据成员。注意，在静态数据成员
                  定义之前，CupBoard类先定义了一个Bowl类型的非静态数据成员bowl3。由输出可见，静态初始化只有在必要时刻才会进行。
                  如果不创建Table对象，也不引用Table.bowl1和Table.bowl2，那么静态的Bowl b1和b2永远都不会创建。只有在第一个Table
                  对象被创建（或者第一次访问静态数据）的时候，它们才会被初始化。此后，静态对象不会再次被初始化。
               初始化的顺序
                  先静态对象（如果它们尚未因前面的对象过程而被初始化），而后是非静态对象。从输出结果中可以观察到这一点。要执行
                  main()（静态方法），必须加载StaticInitialization类，然后其静态域table和cupBoard被初始化，这将导致它们对应的类也被
                  加载，并且由于它们也都包含静态的Bowl对象，因此，Bowl随后也被加载。
                  总结一下对象的创建过程，假设有个名为Dog的类：
                        1 即使没有显示地使用static关键字，构造器实际上也是静态方法。因此，当首次创建类型为Dog的对象时（构造器可以看成
                            静态方法），或者Dog类的静态方法/静态域首次被执行时，Java解释器必须查找类路径，以定位Dog.class文件。
                        2 然后装在Dog.class（后面会学到，这将创建一个Class对象）,有关静态初始化的所有动作都会执行。因此，静态初始化
                            只在Class对象首次加载的时候进行一次。
                        3 当用new Dog()创建对象的时候，首先将在堆上为Dog对象分配足够的存储空间。
                        4 这块存储空间会被清零，这就自动地将Dog对象中的所有基本类型数据都设置成了默认值，而引用则被设置成了null。
                        5 执行所有出现于字段定义处的初始化动作。
                        6 执行构造器。
            5.7.3 显示的静态初始化
                    Java允许将多个静态初始化动作组织成一个特殊的“静态子句”静态块。静态初始化动作只执行一次。
            5.9 枚举类型

    */
}

class Rock{
    public Rock() {
        System.out.println("Rock");
    }

    static void f(String s, int i) {
        System.out.println("String: " + s + "Integer: " + i);
    }

    static void f(int i, String s){
        System.out.println( "Integer: " + i + "String: " + s);
    }
}

class SimpleConstructor{
    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            new Rock();

        }
        Rock.f(9,"dfasf");
        Rock.f("fdsaf",0);
    }
}

//静态数据的初始化
class Bowl {
    Bowl(int marker){
        System.out.println("Bowl(" + marker + ")");
    }
    void f(int marker){
        System.out.println("Bowl.f1(" + marker + ")");
    }
}
class Table{
    static Bowl bowl1 = new Bowl(1);
    Table(){
        System.out.println("Table()");
        bowl2.f(1);
    }
    static Bowl bowl2 = new Bowl(2  );

    void f2(int marker){
        System.out.println("Table.f2(" + marker + ")");
    }
}

class CupBoard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    CupBoard(){
        System.out.println("CupBoard()");
        bowl4.f(2);
    }
    static Bowl bowl5 = new Bowl(5 );
    void f3(int marker) {
        System.out.println("CupBoard.f3(" + marker + ")");
    }
}

class StaticInitialization{
    public static void main(String[] args){
        System.out.println("Creating new CupBoard() in main");
        new CupBoard();
        System.out.println("Creating new CupBoard() in main");
        new CupBoard();
        table.f2(1);
        cupBoard.f3(1);
    }
    static Table table = new Table();
    static CupBoard cupBoard = new CupBoard();

    /*
        output:
        Bowl(1)
        Bowl(2)
        Table()
        Bowl.f1(1)
        Bowl(4)
        Bowl(5)
        Bowl(3)
        CupBoard()
        Bowl.f1(2)
        Creating new CupBoard() in main
        Bowl(3)
        CupBoard()
        Bowl.f1(2)
        Creating new CupBoard() in main
        Bowl(3)
        CupBoard()
        Bowl.f1(2)
        Table.f2(1)
        CupBoard.f3(1)
     */
}

class ArrayNew {
    public static void main(String[] args){
        /*int[] a;
        Random random = new Random(47);
        a = new int[random.nextInt(20)];
        System.out.println(Arrays.toString(a));*/


        // 非基本类型的数组，一个引用数组
        Integer[] a;
        Random random = new Random(47);
        a = new Integer[random.nextInt(20)];
        System.out.println(Arrays.toString(a));
    }
}

enum Spiciness {
    NOT,MILD,MEDIUM,HOT,FLAMING
}

class SimpleEnumUses{
    public static void main(String[] args) {
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot);
        for (Spiciness spiciness: Spiciness.values()) {
            System.out.println(spiciness + ".ordinal " + spiciness.ordinal());
        }
    }
}