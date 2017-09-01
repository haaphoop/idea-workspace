package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    /*
    * 必须为ByteArrayInputStream提供字节数组，为了产生该数组String包含了一个可以实现此项工作的getBytes()方法。所产生的
    * ByteArrayInputStream是一个是个传递给DataInputStream的InputStream。
    * */
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream
                    (BufferedInputFile.read("E:\\idea-workspace\\idea-workspace1\\src\\com\\" +
                            "company\\haaphoop\\thinkingInJava\\chapter18" +
                            "\\FormattedMemoryInput.java").getBytes()));
            while (true) {
                System.out.print((char)in.readByte());
            }
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
}
