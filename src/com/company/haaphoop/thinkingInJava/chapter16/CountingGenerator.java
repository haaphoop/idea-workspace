package com.company.haaphoop.thinkingInJava.chapter16;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

public class CountingGenerator {
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;

        @Override
        public java.lang.Boolean next() {
            value = ! value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value = 0;

        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghjklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements Generator<java.lang.Character> {
        int index = -1;

        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int length = 7;
        Generator<java.lang.Character> cg = new Character();

        public String() {}

        public String(int length) {
            this.length = length;
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        private short value = 0;

        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int value = 0;

        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private long value = 0;

        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        private float value = 0;

        @Override
        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        private double value = 0;

        @Override
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }

    /*
    * 上面的每个类都实现了某种意义的“计数”。在CountingGenerator
    * .Character中，计数只是不断重复大写和小写字母；CountingGenerator
    * .String类使用CountingGenerator
    * .Character来填充一个字符数组，该数组将被转换为String，数组的尺寸取决于构造器参数。请注意，CountingGenerator
    * .String使用的是基本的Generator<java.lang.Character>，而不是具体的对CountingGenerator
    * .Character的引用。稍后，我们可以替换这个生成器，以生成RandomGenerator.java中的RandomGenerator
    * .String。下面是一个测试工具，针对嵌套的Generator
    * 这一贯用法，因为使用了反射所以这个工具可以遵循下面的形式来测试Generator的任何集合。GeneratorsTest.java
    * */

}
