package com.company.haaphoop.thinkingInJava.chapter13;

import java.util.Arrays;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/13 21:01
 * @Modified:
 */
public class Splitting {
    /*
    * 第一个语句，这里用的是普通的字符作为正则表达式，其中并不包含任何特殊的字符。因此第一个split()只是按空格
    * 来划分字符串。
    * 第二个和第三个split()都用到了\W,它的意思是非单词字符(如果W小写，\w,则表示一个单词字符)。通过第二个例子可以看到，它
    * 将标点字符删除了。
    * 第三个split()表示“字母n后面跟着一个或多个非单词字符。” 可以看到，在原石字符串中，与正则表达式匹配的部分，在最终结果中都不
    * 存在了。
    * */
    public static String knights = "Then, when you have " +
            "found the shrubbery, you must " + "with... a herring!";
    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}
