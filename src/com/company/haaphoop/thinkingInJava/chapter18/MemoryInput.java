package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException{
        //read()是以int形式返回一个字节，因此必须类型转换为char才能正确打印。
        StringReader in = new StringReader(BufferedInputFile.read
                ("E:\\idea-workspace\\idea-workspace1\\src\\com\\" +
                        "company\\haaphoop\\thinkingInJava" +
                        "\\chapter18\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
