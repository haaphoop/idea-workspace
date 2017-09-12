package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
* display()方法打开了一个文件，并以double值的形式显式了其中的七个元素。在main()中，首先创建了文件，然后打开并修改它。因为
* double总是8字节长，所以为了用seek()查找第5个双精度值，你只需用5*8来产生查找位置。
* 正如先前所指，RandomAccessFile除了实现DataInput和DataOutput接口之外，有效地与I/O
* 继承层次结构的其他部分实现了分离。因为它不支持装饰，所以不能将其与InputStream及OutputStream
* 子类的任何部分组合起来。我们必须假定RandomAccessFile已经被正确缓冲，因为我们不能为它添加这样的功能。
* 可以自行选择的是第二个构造器参数：我们可指定以"只读r或读写rw"方式打开一个RandomAccessFile文件。
* 你可能会考虑内存映射文件来代替RandomAccessFile。
* */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file,"r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(4 * 8 );
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
