package com.company.serializable;

import java.io.*;

/**
 * Created by daishuli on 2017/8/9.
 */
public class SerialEncry implements Serializable {
    private static final long serialVersionUID = 1L;
    private String password = "pass";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void writeObject(ObjectOutputStream out) {
        try {
            ObjectOutputStream.PutField putField = out.putFields();
            System.out.println("原密码：" + password);
            password = "encryption";//模拟加密
            putField.put("password", password);
            System.out.println("加密后密码：" + password);
            out.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField getField = in.readFields();
            Object obj = getField.get("password", "");
            System.out.println("要解密的字符串： " + obj.toString());
            password = "pass";//模拟解密，需要获得本地的密钥
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
            out.writeObject(new SerialEncry());
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("result.obj"));
            SerialEncry serialEncry = (SerialEncry)in.readObject();
            System.out.println("解密后的字符串：" + serialEncry.getPassword());
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
