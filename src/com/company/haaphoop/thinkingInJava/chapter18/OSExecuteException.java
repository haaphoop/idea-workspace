package com.company.haaphoop.thinkingInJava.chapter18;

/*
*   要想运行一个程序，需要像OSExcute.command()传递一个command字符串，它与你在控制台上运行该程序
*   所键入的命令相同。这个命令被传递给java.lang.ProcessBuilder构造器（它要求这个命令作为一个String对象序列而被传递），
*   然后所产生的ProcessBuilder对象被启动：OSExcute.java
* */
public class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}
