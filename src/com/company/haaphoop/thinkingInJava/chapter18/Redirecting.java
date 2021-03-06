package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.*;

/*
* 这个程序将标准输入附接到文件上，并将标准输出和标准错误重定向到另一个文件上。注意，它在程序开头处存储了对最初的System.out对象的引用，
* 并且在结尾处将系统输出恢复到了该对象上。
* I/O重定向操纵的是字节流，而不是字符流；因此，我们使用的是InputStream和OutputStream，而不是Reader和Writer。
* */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream
                ("E:\\idea-workspace\\idea-workspace1\\src\\com\\company" +
                        "\\haaphoop\\thinkingInJava\\chapter18\\Redirecting" +
                        ".java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new
                FileOutputStream("test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System
                .in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }

        out.close();
        System.setOut(console);
    }
}
