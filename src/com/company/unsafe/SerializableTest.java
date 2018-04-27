package com.company.unsafe;

import sun.misc.Unsafe;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by daishuli on 2018/4/27.
 */
public class SerializableTest implements Serializable {
    private final int num;

    public SerializableTest(int num) {
        System.out.println("SerializableTest Constructor");
        this.num = num;
    }
    public int getNum() {
        return num;
    }

    public static void main(String[] args)  throws NoSuchFieldException,NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Unsafe unsafe = getUnsafe2();
        SerializableTest s = (SerializableTest)unsafe.allocateInstance(SerializableTest.class);
        System.out.println(s.getNum());
        Field f = SerializableTest.class.getDeclaredField("num");
        // 获取字段在对象内部的偏移量
        long fieldOffSet = unsafe.objectFieldOffset(f);
        // 通过偏移量设置属性值
        unsafe.putInt(s, fieldOffSet, 10);
        System.out.println(s.getNum());
        unsafe.putInt(s, fieldOffSet, 15);
        System.out.println(s.getNum());
    }
    public static Unsafe getUnsafe2() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor constructor = Unsafe.class.getDeclaredConstructor(new Class<?>[0]);
        constructor.setAccessible(true);
        return (Unsafe) constructor.newInstance(new Object[0]);
    }
}
