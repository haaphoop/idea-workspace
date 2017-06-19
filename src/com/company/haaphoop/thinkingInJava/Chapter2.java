package com.company.haaphoop.thinkingInJava;

/**
 * Created by daishuli on 2017/6/19.
 */
public class Chapter2 {
    public static void main(String[] args) {
        // write your code here
        String s = "";
        // 字符串可以用带引号的文本初始化
        String t = new String("asdf");
        System.out.println(t);
        /*  2.2 必须由你创建所有对象
            2.2.1 存储到什么地方
            1 寄存器 最快的存储区 位于处理器内部 寄存器数量有限
            2 堆栈 位于通用RAM(随机访问存储器) 对象引用位于堆栈中 java对象不存储于此。通过堆栈指针直接从处理器获得支持。
                堆栈指针向下移动，分配新的内存，向上移动，释放那些内存，速度仅次于寄存器
            3 堆 一种通用的内存池（位于RAM区），用于存放所有java对象。创建新对象时自动在堆里存储分配。代价是堆进行存储和分配
                比堆栈需要更多时间
            4 常量存储 常量值通常直接存放在程序代码内部，因为常量永远不会被改变
            5 非RAM存储 如果数据完全存活于程序之外，那么它可以不受程序任何控制，在程序没有运行时也可以存在。其中，两个基本
                的例子是流对象和持久化对象。
        */

    }
}
