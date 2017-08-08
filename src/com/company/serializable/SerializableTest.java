package com.company.serializable;

import java.io.Serializable;

/**
 * Created by daishuli on 2017/8/8.
 */
public class SerializableTest implements Serializable{
    /*
    * 序列化ID在Eclipse 下提供了两种生成策略
    * 一个是固定的1L,一个是随机生成一个不重复的long类型数据（实际上是使用jdk工具生成）
    * 如果没有特殊需求，默认1L就可以
    * */
    static final long serialVersionUID = 1L;
    String name;
    int num;
    static int staticNum;
    /*
    * transient关键字是不能被虚拟机默认序列化的，如果想序列化需要重写private void writeObject(ObjectOutputStream s) 和 private readObject(ObjectInputStream in)方法
    * */
    transient String pwd;

    transient int num0;

    public SerializableTest(String name, int num, int staticNum, String pwd, int num0) {
        this.name = name;
        this.num = num;
        this.staticNum = staticNum;
        this.pwd = pwd;
        this.num0 = num0;
    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", pwd='" + pwd + '\'' +
                ", num0=" + num0 +
                '}';
    }


}
