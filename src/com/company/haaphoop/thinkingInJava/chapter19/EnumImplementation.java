package com.company.haaphoop.thinkingInJava.chapter19;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.Random;

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ". ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random random = new Random(47);
    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}