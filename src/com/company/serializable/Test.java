package com.company.serializable;

import java.io.*;

/**
 * Created by daishuli on 2017/8/9.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Child child = new Child();
            child.c = 10;
            child.p = 5;
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
            out.writeObject(child);
            System.out.println(new File("result.obj").length());
            out.flush();
            child.c = 11;
            out.writeObject(child);
            out.close();
            System.out.println(new File("result.obj").length());
            StaticVarTest.staticVar = 10;
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("result.obj"));
            Child test = (Child)in.readObject();
            Child test1 = (Child)in.readObject();
            in.close();
            System.out.println(test.c);
            System.out.println(test1.c);
            System.out.println(test == test1);
        } catch (FileNotFoundException e){e.printStackTrace();} catch (IOException e) {e.printStackTrace();} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
