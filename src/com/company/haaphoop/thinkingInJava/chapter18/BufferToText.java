package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;

    /*
    * 缓冲器容纳的是普通的字节，为了把它们转换成字符，要么在输入它们的时候对其进行编码，要么在将其从缓冲器输出时对
    * 它们进行解码。可以使用java.nio
    * .charset类实现这些功能，该类提供了把数据编码成多种不同类型的字符集的工具：AvailableCharSets.java
    * */
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data3.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("data3.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        System.out.println(buffer.asCharBuffer());
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset
                .forName(encoding).decode(buffer));
        fc = new FileOutputStream("data3.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
