package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader
                (BufferedInputFile.read("E:\\idea-workspace\\idea-workspace1\\src\\com\\company\\haaphoop\\thinkingInJava\\chapter18\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter
                (file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));

        /*
        * 当文本行被写入文件时，行号就会增加。注意并未用到LineNumberInputStream
        * ，因此这个类没有多大帮助，所以我们没有必要用它。从本例中可以看出，记录自己的行号很容易。
        * 一旦读完输入数据流，readLine()会返回null。我们可以看到要为out显式调用close()。如果我们不为所有的输出文件调用
        * close()，就会发现缓冲区内容不会被刷新清空，那么它们也就不完整。
        * */
    }
}