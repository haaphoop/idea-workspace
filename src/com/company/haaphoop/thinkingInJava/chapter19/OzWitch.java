package com.company.haaphoop.thinkingInJava.chapter19;

/*
* 注意，如果打算定义自己的方法，那么必须在enum实例序列的最后添加一个分号。同时，Java要求必须先定义enum实例。如果
* 在定义enum实例之前定义了任何方法或属性，那么在编译时就会得到错误信息。
* enum中的构造器与方法和普通的类没有区别，因为除了有少许限制之外，enum就是一个普通的类。所以，可以使用enum做许多事情。
*   在这个例子中，虽然有意识地将enum的构造器声明为private，但对于它的可访问性而言，其实并没有什么变化，因为我们只能在enum
*   定义的内部使用其构造器创建enum实例。一旦enum的定义结束，编译器就不允许我们再使用其构造器来创建任何实例了。
* */
public enum OzWitch {
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wear of the Ruby " + "Slippers, crushed " +
            "by Dorothy‘s house"),
    SOUTH("Good by inference, but missing");
    private String description;
    private OzWitch(String description){
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch : OzWitch.values()) {
            System.out.println(ozWitch + " : " + ozWitch.getDescription());
        }
    }
}
