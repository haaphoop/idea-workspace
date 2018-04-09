package com.company.haaphoop.thinkingInJava.chapter18;

import java.io.File;

public class DirectoryDemo {

    /*
    * 可以更进一步，创建一个工具，它可以在目录中穿行，并且根据Strategy
    * 对象来处理这些目录中的文件（这是策略设计模式的另一个示例）:ProcessFiles.java
    * */
    public static void main(String[] args) {
       // PPrint.pprint(Directory.walk(".").dirs);

        /*for (File file : Directory.local(".", ".*")){
            System.out.println(file);
        }

        for (File file : Directory.walk(".", ".*\\.java")) {
            System.out.println(file);
        }*/

        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            System.out.println(file);
        }
    }
}
