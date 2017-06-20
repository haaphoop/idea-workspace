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
            2.2.2 特例 基本类型
            基本类型存储与堆栈中，高效 每种类型占存储空间大小：boolean 不指定具体大小;byte * 8;char * 16 short * 16; int * 32 float * 32; double * 64 long * 64; 包装器类型：Boolean Character Integer Byte Short Float Double Long
            基本类型具有包装器类，使得可以在堆中创建一个非基本对象，用来表示对应得基本对象
            Java SE5 得自动包装功能会自动得将基本类型转换为包装器类型；
            高精度数字
            BigInteger 支持任意精度得整数 BigDecimal 支持任意精度得定点数 对应int float 牺牲速度换取精度

            对象的作用域
            String s = new String("a string");
            引用s在作用于结束时就消失了，然而s指向的String对象仍继续占据内存空间
        */


    }
}

class DataOnly {
    int i;double d;boolean b;

    void print(){return;// return 作用是退出方法}
}