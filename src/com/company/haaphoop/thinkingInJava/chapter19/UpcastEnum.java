package com.company.haaphoop.thinkingInJava.chapter19;

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}

enum Search {
    HITHER, YON
}

class NonEnunm {
    public static void main(String[] args) {
        Class<Integer> integerClass = Integer.class;
        try {
            for (Object en : integerClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}