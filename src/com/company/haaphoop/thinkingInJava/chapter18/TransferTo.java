package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream
                ("E:\\idea-workspace\\idea-workspace1\\data1.txt").getChannel();
        FileChannel out = new FileOutputStream
                ("E:\\idea-workspace\\idea-workspace1\\data2.txt")
                .getChannel();
        in.transferTo(0, in.size(), out);
    }
}
