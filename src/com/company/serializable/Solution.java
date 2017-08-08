package com.company.serializable;

import java.io.*;

/**
 * Created by daishuli on 2017/8/8.
 */
public class Solution {
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = null;
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
        System.out.println(mts.equals(serializableTest));

    }
}
