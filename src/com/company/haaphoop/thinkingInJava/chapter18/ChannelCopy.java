package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    /*
    * 可以看到，打开一个FileChannel以用于读，而打开另一个以用于写。ByteBuffer被分配了空间，当FileChannel.read
    * ()返回-1时，表示我们已经达到了输入的末尾。每次read()操作之后，就会将数据输入到缓冲器中，flip()则是准备缓冲器
    * 以便它的信息可以由write()提取。write()操作之后，信息仍在缓冲器中，接着clear()操作则对所有的内部指针重新安排，以便缓冲器在另一个
    * read()操作期间能够做好接受数据的准备。
    *   然而，上面那个程序并不是处理此类操作的理想方式。特殊方法transferTo()和transferFrom()
    *   则允许我们将一个通道和另一个通道直接相连：TransferTo.java
    *
    * */
    public static void main(String[] args) throws Exception {
        String[] arg = {"E:\\idea-workspace\\idea-workspace1\\data.txt",
                "E:\\idea-workspace\\idea-workspace1\\data1.txt"};
        if (arg.length != 2) {
            System.out.println("arguments : soutcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(arg[0]).getChannel();
        FileChannel out = new FileOutputStream(arg[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) !=  -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}
