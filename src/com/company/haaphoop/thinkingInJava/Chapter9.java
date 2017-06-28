package com.company.haaphoop.thinkingInJava;

import java.util.Arrays;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/6/22 20:37
 * @Modified:
 */
public class Chapter9 {

    /*
    * 9.1 抽象类和抽象方法
    *       包含抽象方法的类称为抽象类。如果一个类包含一个或多个抽象方法，该类必须被限定为抽象的。
    * 9.2 接口
    *       interface 关键字产生一个完全抽象的类。接口可以包含域，但这些域隐式地是static和final的。
    *       可以在接口中显示地将方法声明为public的，但即使不这么做，它们也是public的。因此，当要实现
    *       一个接口时，在接口中被定义的方法必须被定义为public的；否则，它们将只能得到默认的包访问权限，这样在方法
    *       被继承过程中，其可访问权限就被降低了，这是java编译器做不允许的。在接口中任何方法即使没有被声明为public
    *       但它们默认就是public的。
    * 9.3 完全解耦
    *      协变类型：指的是子类中的成员函数的返回值不必严格等同于父类中被重写的成员函数的返回值类型，而可以是
    *      更窄的类型。Java 5.0 添加了对协变类型的支持，即子类覆盖（重写）基类方法时，返回的类型可以是基类方法
    *      返回类型的子类。协变返回类型允许返回更为具体的类型。
    *
    *      创建一个能够根据所传递的参数对象的不同而具有不同行为的方法，被称为策略设计模式。这类方法包含所要执行
    *      的算法中固定不变的部分，而策略包含变化的部分。策略就是传递进去的参数对象，它包含要执行的代码。
    *
    *
    * */
}

class Processor {
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){
        return input;
    }
}

class Upcase extends Processor {
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input){
        String[] spliters = ((String) input).split(" ");
        for (String spliter : spliters) {
            System.out.println(spliter);
        }
        return Arrays.toString(spliters);
    }
}

class Apply {

    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void process(Processor processor, Object input) {
        System.out.println("Using Processor : " + processor.name());

        System.out.println(processor.process(input));
    }

    public static void process(Filter filter, Object input) {
        //System.out.println("Using Processor : " + waveform.name());

       // System.out.println(waveform.process(input));
    }

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}

class Waveform{
    private static long counter;
    private final long id = counter++;
    public String toString(){return "Waveform " + id;}
}

class Filter {
    public String name(){return getClass().getSimpleName();}
    public Waveform process(Waveform input){
        return input;
    }
}

class LowPass extends Filter {
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}

class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}

class BandPass extends Filter {
    double lowoff, highoff;
    public BandPass(double lowoff, double highoff){
        this.lowoff = lowoff;
        this.highoff = highoff;
    }
    public Waveform process(Waveform input){
        return input;
    }
}

/*
interface Processor{
    String name();
    Object process(Object object);
}
class Waveform {
    private static long counter;
    private final long id = ++counter;
    public String toString(){
        return "Waveform " + id;
    }
}
class LowPass extends Filter {
    double cutoff;
    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}

class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}

class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCutoff, double highCutoff ) {
        this.lowCutoff= lowCutoff;
        this.highCutoff = highCutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}
class Filter {
    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process (Waveform input) {
        return input;
    }
}
class Apply {
    public static void process(Processor processor, Object object){
        System.out.println("Using Processor " + processor);
        System.out.println(processor.process(object));
    }
}
class FilterAdapter implements Processor {
    Filter filter;
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }

    public String name(){
        return filter.name();
    }

    public Waveform process(Object input){
        return filter.process((Waveform)input);
    }
}


class FilterProcessor {
    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), waveform);
        Apply.process(new FilterAdapter(new HighPass(2.0)), waveform);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)), waveform);
    }
}*/
