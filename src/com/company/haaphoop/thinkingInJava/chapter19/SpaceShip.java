package com.company.haaphoop.thinkingInJava.chapter19;

/*
* toString()方法通过调用name()方法取得SpaceShip的名字，然后将其修改为只有首字母大写的格式。
* */
public enum SpaceShip {
    SCOUT, CARGD, TRANSPORT,CRUISER, BATTLESHIP, MOTHERSHI;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip spaceShip: SpaceShip.values()) {
            System.out.println(spaceShip.toString());
        }
    }
}
