package com.company.haaphoop.thinkingInJava.chapter11;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 22:01
 * @Modified:
 */
public class StackTest {
    /*
    * 如果你想在自己的代码中使用这个Stack类，当你在创建其实例时，就需要完整指定包明，或者更改这个类的名称；否则，就有可能与java.util
    * 包中的Stack发生冲突。例如，如果我们在上面的例子中导入java.util.*，那么久必须使用包名以防止冲突：
    * */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String[] s = "My dog has fleas".split(" ");
        for (String string : s) {
            stack.push(string);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();

        java.util.Stack<String> stack1 = new java.util.Stack<String>();

        for (String s1 : s) {
            stack1.push(s1);
        }

        while (!stack1.empty()) {
            System.out.print(stack1.pop() + " ");
        }

        System.out.println();

        /*
        * 这两个Stack具有相同的接口，但是在java.util中没有任何公共的Stack接口。
        * */
    }
}
