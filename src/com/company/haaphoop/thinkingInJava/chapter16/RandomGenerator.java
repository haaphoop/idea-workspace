package com.company.haaphoop.thinkingInJava.chapter16;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random(47);
    public static class Boolean implements Generator<java.lang.Boolean> {
        @Override
        public java.lang.Boolean next() {
            return random.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        @Override
        public java.lang.Byte next() {
            return (byte)random.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {
        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[random.nextInt(CountingGenerator.chars
                    .length)];
        }
    }

    public static class String extends CountingGenerator.String {
        {   cg = new Character();}
        public String(){}
        public String(int length){ super(length);}
    }

    public static class Short implements Generator<java.lang.Short> {
        @Override
        public java.lang.Short next() {
            return (short)random.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int mod = 10000;
        public Integer() {}
        public Integer(int module) { mod = module;}

        @Override
        public java.lang.Integer next() {
            return random.nextInt(mod);
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private int mod = 10000;
        public Long(){}
        public Long(int module) {mod = module;}

        @Override
        public java.lang.Long next() {
            return new java.lang.Long(random.nextInt(mod));
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        @Override
        public java.lang.Float next() {
            int trimmed = Math.round(random.nextFloat() * 100);
            return ((float)trimmed) / 100;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        @Override
        public java.lang.Double next() {
            long trimmed = Math.round(random.nextDouble() * 100);
            return ((double)trimmed) / 100;
        }
    }
    /*
    * 可以看到，RandomGenerator.String继承自CountingGenerator
    * .String，并且只是插入了新的Character生成器。
    * 为了不生成过大的数字，RandomGenerator
    * .Integer默认使用的模数为10000，但是重载的构造器允许你选择更小的值。同样的方式也应用到了RandomGenerator
    * .Long上。对于Float和Double生成器，小数点之后的数字被截掉了。
    * */
}
