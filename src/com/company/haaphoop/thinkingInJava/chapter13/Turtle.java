package com.company.haaphoop.thinkingInJava.chapter13;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/12 22:52
 * @Modified:
 */
public class Turtle {
    /*
    * 所有的tommy都将输出到System.out,而所有的terry则都输出到System.out的一个别名中。
    * Formatter的构造器经过重载可以接受多种输出目的地，不过最常用的还是PrintStream()、OutputStream和File。
    * 前面的示例中还使用了一个新的格式修饰符%s，它表示插入的参数是String类型。这个例子使用的是最简单类型的
    * 格式修饰符---它只具有转换类型而没有其他功能。
    * */
    private String name;
    private Formatter formatter;
    public Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle turtle = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        turtle.move(0,0);
        terry.move(4,8);
        turtle.move(3,4);
        terry.move(2,5);
        turtle.move(3,3);
        terry.move(3,3);
    }
}
