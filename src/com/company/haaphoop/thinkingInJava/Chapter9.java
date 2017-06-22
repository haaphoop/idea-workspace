package com.company.haaphoop.thinkingInJava;

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
    * 9.3 完全解耦
    *
    *
    *
    * */
}

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
}