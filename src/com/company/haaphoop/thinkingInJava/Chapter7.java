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
    *
    *
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