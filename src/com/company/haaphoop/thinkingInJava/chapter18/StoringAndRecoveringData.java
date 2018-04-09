package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.*;

public class StoringAndRecoveringData {
    /*
    * 如果我们使用DataOutputStream写入数据，Java保证我们可以使用DataInputStream
    * 准确地读取数据--无论读和写数据的平台多么不同。这一点很有价值，因为我们都知道，人们曾经花费了大量时间去处理特定于平台的数据问题。
    * 只要两个平台上都有Java，则会中问题就不会再发生。
    * 当我们使用DataOutputStream时，写字符串并且让DataInputStream能够恢复它的唯一可靠的做法就是使用UTF
    * -编码，在这个示例中是用writeUTF()和readUTF()来实现的。UTF-8是一种多字节格式，其编码长度根据实际使用的字符集会有所变化。
    * 如果我们使用的只是ASCII字符编码成单一字节的形式，而非ASCII字符则编码成两到三个字节的形式。另外，字符串的长度存储在UTF-8
    * 的前两个字节中。但是，writeUTF()和readUTF()
    * 使用的是适合于Java的UTF-8的变体，因此如果我们用一个Java程序读取用writeUTF()
    * 所写的字符串时，必须编写一些特殊代码才能正确读取字符串。
    * 有了writeUTF()和readUTF()，我们就可以用DataOutputStream把字符串和其他数据类型相混合，我们知道字符串完全可以作为
    * Unicode来存储，并且可以很容易地使用DataInputStream来恢复它。
    *   writeDouble()将double类型的数字存储到流中，并用相应的readDouble()
    *   恢复它（对于其他的数据类型，也有类似方法用于读写）。但是为了保证所有的读方法都能够正常工作，我们必须知道流中数据项所在的确切位置，因为极有可能将保存的
    *   double数据作为一个简单的字节序列、char
    *   或其他类型读入。因此，我们必须：要么为文件中的数据采用固定的格式；要么将额外的信息保存到文件中，以便能够对其进行解析以
    *   确定数据的存放位置。注意，对象序列化和XML可能是更容易的存储和读取复杂数据结构的方式。
    * */
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream
                (new FileOutputStream("Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That wai pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new
                FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
