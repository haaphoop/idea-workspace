package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput1 {
    static String file = "E:\\idea-workspace\\idea-workspace1\\src\\com" +
            "\\company\\haaphoop\\thinkingInJava\\chapter18" +
            "\\BasicFileOutput1.out";

    /*
    * 仍旧是在进行缓存，只是不必自己去实现。遗憾的是，其他常见的写入任务都没有快捷方式，因此典型的I/O仍旧包含大量的冗余文本。但是，
    * 本书所使用的在本章稍后进行定义的TextFile工具简化了这些常见任务。
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader
                (BufferedInputFile.read("E:\\idea-workspace\\idea-workspace1" +
                        "\\src\\com\\company\\haaphoop\\thinkingInJava" +
                        "\\chapter18\\BasicFileOutput1.java")));
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
