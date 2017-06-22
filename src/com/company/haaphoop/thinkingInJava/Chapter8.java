package com.company.haaphoop.thinkingInJava;

import java.util.Random;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/6/22 13:39
 * @Modified:
 */
public class Chapter8 {
    /*
    *
    *
    *
    *
    *
    * */
}

enum Note {
    MIDDLE_C,C_SHARP,B_FLAT
}
class Instruments {
    public void play(Note note){
        System.out.println("Instrument.play()");
    }
}

class Winds extends Instruments {
    public void play(Note note){
        System.out.println("Winds.play() " + note);
    }
}

class Music {
    public static void tune(Instruments instruments) {
        instruments.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Instruments flute = new Winds();
        tune(flute);
    }
}

class Shape {
    public void draw(){System.out.println("Shape.draw()");}
    public void erase(){System.out.println("Shape.erase()");}
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle.draw()");
    }
    public void erase() {
        System.out.println("Circle.erase()");
    }
}

class Square extends Shape {
    public void draw() {
        System.out.println("Square.draw()");
    }
    public void erase() {
        System.out.println("Square.erase()");
    }
}

class Triangle extends Shape {
    public void draw() {
        System.out.println("Triangle.draw()");
    }
    public void erase() {
        System.out.println("Triangle.erase()");
    }
}

class RandomShapeGenerator {
    private Random random = new Random(47);
    public Shape next(){
        Random random = this.random;
        switch (random.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }
}

class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args){
        Shape[] s = new Shape[9];
        for (int i= 0 ;i < s.length; i++) {
            s[i] = gen.next();
        }

        for (Shape shape : s) {
            shape.draw();
        }
    }
}