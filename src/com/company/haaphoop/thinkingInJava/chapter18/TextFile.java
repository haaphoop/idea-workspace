package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/*
* read()将每行添加到StringBuffer，并且为每行加上换行符，因为在读的过程中换行符会被去除掉。接着返回一个包含
* 整个文件的字符串。write()打开文本并将其写入文件。在这两个方法完成时，都要记着用close()关闭文件。
*   注意，在任何打开文件的代码在finally子句中，作为防卫措施都添加了对文件的close()调用，以保证文件将会被正确关闭。
*    这个构造器利用read()方法将文件转换成字符串，接着实用String.split()
*    以换行符为界把结果划分成行（若要频繁实用这个类，我们可以重写此构造器以提高性能）。遗憾的是没有相应的连接(join)方法，所以那个非
*    静态的write()方法必须一行一行地输出这些行。因为这个类希望将读取和写入文件的过程简单化，因此所有的IOException
*    都被转型为RuntimeException，因此用户不必实用try-catch语句块。但是，你可能需要创建另一种版本将IOException
*    传递给调用者。
*    在main()方法中，通过执行一个基本测试来确保这些方法正常工作。尽管这个程序不需要创建许多代码，但实用它会节约大量时间，它会使你变得很轻松。
*    另一种解决读取文件问题的方法是使用在Java SE5中引入的java.util
*    .Scanner类。但是，这只能用于读取文件，而不能用于写入文件，并且这个工具主要是设计用来创建编程语言的扫描器或“小语言”的。
* */
public class TextFile extends ArrayList<String> {
    public static String read(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File
                    (filename).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String filename, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String filename, String splitter) {
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String filename) {
        this(filename, "\n");
    }

    public void write(String filename) {
        try {
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try {
                for (String item : this) {
                    out.print(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("E:\\idea-workspace\\idea-workspace1\\src\\com" +
                "\\company\\haaphoop\\thinkingInJava\\chapter18\\TextFile" +
                ".java");
        System.out.println(file);
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<String>(
                new TextFile("E:\\idea-workspace\\idea-workspace1\\src\\com" +
                        "\\company\\haaphoop\\thinkingInJava\\chapter18" +
                        "\\TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
