package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;

    /*
    * 对于这里所展示的任何流类，getChannel()
    * 将会产生一个FileChannel。通道是一种相当基础的东西：可以向它传送用于读写的ByteBuffer，并且可以锁定文件的某些区域用于独占式访问。
    *   将字节存放于ByteBuffer的方法之一是：使用一种"put
    *   "方法直接对它们进行填充，填入一个或多个字节，或基本数据类型的值。不过，正如所见，也可以使用warp()
    *   方法将已存在的字节数组“包装”到ByteBuffer中。一旦如此，就不再复制底层的数组，而是把它作为所产生的ByteBuffer
    *   的存储器，我们称之为数组支持的ByteBuffer。
    *   data.txt文件用RandomAccessFile被再次打开。注意我们可以再文件内随处移动FileChannel
    *   ；在这里，我们把它移到最后，以便附加其他的写操作。
    *   对于只读访问，我们必须显式地使用静态的allocate()
    *   方法来分配ByteBuffer。nio的目标就是快速移动大量数据，因此ByteBuffer
    *   的大小就显得尤为重要-----实际上，这里使用的1K可能比我们通常要使用的小一点（必须通过实际运行应用程序来找到最佳尺寸）。
    *
    *   甚至达到更高的速度也有可能，方法就是使用allocateDirect()而不是allocate()
    *   ，以产生一个与操作系统有更高耦合性的“直接”缓冲器。但是，这种分配的开支会更大。
    *
    *   一旦调用read()来告知FileChannel向ByteBuffer存储字节，就必须调用缓冲器上的flip()
    *   ，让它做好让别人读取字节的准备（是的，这似乎有一点拙劣，但是请记住，它是很拙劣的，但却适用于获取最大速度）。如果我们打算使用
    *   缓冲器执行进一步的read()操作，我们也必须的调用clear()来为每个read()
    *   做好准备。在下面这个简单文件复制程序中可以看到：ChannelCopy.java
    * */
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("E:\\idea-workspace\\idea" +
                "-workspace1\\data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new RandomAccessFile("E:\\idea-workspace\\idea-workspace1\\data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc = new FileInputStream("E:\\idea-workspace\\idea-workspace1\\data" +
                ".txt").getChannel();
        ByteBuffer bu = ByteBuffer.allocate(BSIZE);
        fc.read(bu);
        bu.flip();
        while (bu.hasRemaining()) {
            System.out.print((char)bu.get());
        }
    }
}
