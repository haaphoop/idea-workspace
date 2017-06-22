package com.company.haaphoop.thinkingInJava;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/6/21 20:49
 * @Modified:
 */
public class Chapter7 {

    /*
    * 7.2.1 初始化基类
    *   由于涉及基类和导出类两个类，而不是只有一个类，所以要试着想像导出类所产生的结果对象，会有点困惑。从外部来看
    *   ，它就像是一个与基类具有相同接口的新类，或许还会有一些额外的方法和域。但继承并不只是复制基类的接口。当创建了
    *   一个导出类时，该对象包含了一个基类的子对象。这个子对象与用基类创建的对象是一样的。二者区别在于，后者来自外部
    *   ，而基类的子对象被包装在导出类外部。
    *  7.8 finally 关键字
    *       可能使用finally 关键字的三种场合：数据/方法/类
    *  7.9 继承与初始化
    *       在Beetle上运行java时，所发生的第一件事就是试图访问Beetle.main()，于是加载器开始启动并找出Beetle类的编译代码
    *       在对它加载过程中，编译器注意到它有一个基类（这是由extends关键字得知的），于是它继续进行加载。不管你是否打算产生
    *       一个该基类的对象，这都要发生。如果该基类还有其自身的基类，那么第二个基类就会被加载，如此类推。接下来，根基类中的
    *       static初始化机会被执行，然后是下一个导出类，以此类推。这种方式很重要，因为导出类的static初始化可能会依赖于基类
    *       成员能否被正确初始化。至此为止，必要的类都已加载完毕，对象就可以被创建了。首先，对象中的所有基本类型都会被设为默认值
    *       对象引用设为null---这是通过将对象内存设为二进制零值而一举产生的。然后，基类的构造器被调用。在本例中，它是被自动调用的
    *       但也可以用super来指定对构造器的调用。基类构造器和导出类的构造器一样，以相同的顺序来经历相同的过程。在基类构造器完成
    *       之后，实例变量按其次序被初始化。最后，构造器的其余部分被执行。
    *
    *
    * */
}

class Cleanser {
    private String s = "Cleanser";
    public void append(String a) {
        s+= a;
    }
    public void dilute(){append("dilute()");}
    public void apply(){append("apply()");}

    public void scrub() {
        append("scrub()");
    }

    public String toString() {
        return s;
    }

    public static void main(String[] args){
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
    }
}

class Detergent extends Cleanser {
    public void scrub() {
        append("Detergent.scrub() ");
        super.scrub();
    }

    public void foam(){append(" foam()");}

    public static void main(String[] args){
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();
        System.out.println(detergent);
        System.out.println("Test Bean class");
        Cleanser.main(args);
    }
}

class Homer {
    char doh(char c) {System.out.println("doh(char)");return 'd';}
    float doh(float f) {System.out.println("doh(float)"); return 1.0f;}
}

class Milhouse{}
class Bart extends Homer {
    void doh(Milhouse milhouse){
        System.out.println("Bart.doh(Milhouse)");
    }

    public static void main(String[] args){
        Homer bart = new Bart();
        bart.doh(1);
        bart.doh('x');
        bart.doh(1.0f);
        //bart.doh(new Milhouse());
    }
}

class Instrument {
    public void play(){System.out.println(this);}
    static void tune(Instrument i) {
        i.play();
    }
}

class Wind extends Instrument {
    public String toString() {
        return "Windd";
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        Instrument.tune(wind);
    }
}

// 继承初始化全过程
class Insect {
    private int i = 9;
    protected int j;
    Insect(){
        System.out.println("i = " + i + "," + "j = " + j);
        j = 39;
    }
    private static int x1 = printInit("static Insect.x1 initialized");
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    Beetle(){
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    static int x2 = printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        Beetle beetle = new Beetle();
    }

}
