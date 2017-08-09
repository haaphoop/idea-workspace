package com.company.serializable;

import java.io.*;
import java.util.Date;

/**
 * Created by daishuli on 2017/8/8.
 */
public class Solution {
    public static void main(String[] args) {
        /*ObjectOutputStream objectOutputStream = null;
        SerializableTest serializableTest = new SerializableTest("str",12, 1, "123456", 8 );
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.dat"));
            objectOutputStream.writeObject(serializableTest);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream objectInputStream;
        SerializableTest mts = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("test.dat"));
            mts = (SerializableTest) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(mts);
        // 注意，没有覆盖equals方法，object类的equals()默认是地址比较
        System.out.println(mts.equals(serializableTest));*/

        ObjectOutputStream objectOutputStream = null;
        Administrator administrator = new Administrator(new User("dada", "dada", new Date()), true);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.dat"));
            objectOutputStream.writeObject(administrator);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream objectInputStream;
        Administrator1 administrator1 = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("test.dat"));
            administrator1 = (Administrator1) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(administrator1.equals(administrator));
    }
}
