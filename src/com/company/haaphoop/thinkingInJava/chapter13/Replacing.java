package com.company.haaphoop.thinkingInJava.chapter13;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/13 21:10
 * @Modified:
 */
public class Replacing {
    /*
    * 第一个表达式要匹配的是，以字母f开头，后面跟一个或多个字母(注意这里的w是小写的)。
    * 并且只替换掉第一个匹配的部分，所以"found"被替换成"located"。
    * 第二个表达式要匹配的是三个单词中的任意一个，因为它们以竖线分割表示“或”，并且替换掉所有匹配部分。
    * */
    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceFirst("f\\w+","located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
