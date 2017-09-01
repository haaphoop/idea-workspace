package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new
                FileInputStream("E:\\idea-workspace\\idea-workspace1\\src" +
                "\\com\\company\\haaphoop\\thinkingInJava\\chapter18\\TestEOF" +
                ".java")));
        while (in.available() != 0) {
            System.out.print((char)in.readByte());
        }
    }

    /*
    * 注意，available()的工作方式会随着所读取的媒介类型的不同而有所不同；字面意思就是“在没有阻塞的情况下所能读取的字节数”。
    * 对于文件，这意味着整个文件；但是对于不同类型的流，可能就不是这样的，因此要谨慎使用。
    * 我们也可以通过捕获异常来检测输入的末尾。但是，使用异常进行流控制，被认为是对异常特性的错误使用。
    * */
}
