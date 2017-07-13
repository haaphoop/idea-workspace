package com.company.haaphoop.thinkingInJava.chapter13;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/13 20:49
 * @Modified:
 */
public class IntegerMatch {
    /*
    * 前两个字符串满足对应的正则表达式，匹配成功。第三个字符串开头有一个+，它也是一个合法的整数，
    * 但与对应的正则表达式却不匹配。因此，我们的正则表达式应该描述为：“可能以一个加好或减号开头”。在正则表达式中，
    * 括号有着将表达式分组的效果，而竖直线|则表示或操作。也就是:(-|\\+)?
    * 这个正则表达式表示字符串的起始字符可能是一个-或+,或二者皆没有(因为后面跟着?修饰符)。因为字符+在正则表达式中有
    * 特殊的意义，所以必须使用\\将其转意，使之成为表达式中的一个普通字符。
    * String类还自带了一个非常有用的正则表达式工具----split()方法，其功能是"将字符串从正则表达式匹配的地方切开。"
    * */
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)\\d+"));
    }
}
