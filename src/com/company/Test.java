package com.company;

import sun.misc.Unsafe;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by daishuli on 2018/4/24.
 */
public class Test {
    private static int byteArrayBaseOffset;

    public static void main(String[] args) throws NoSuchFieldException,IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = (Unsafe)theUnsafe.get(null);
        System.out.println(UNSAFE);

        // 在堆外分配一个byte
        long allocatedAddress = UNSAFE.allocateMemory(1L);
        UNSAFE.putByte(allocatedAddress, (byte)100);
        byte shortValue = UNSAFE.getByte(allocatedAddress);
        System.out.println(new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:").append(shortValue));

        // 重新分配一个long
        allocatedAddress = UNSAFE.reallocateMemory(allocatedAddress, 8L);
        UNSAFE.putLong(allocatedAddress, 1024L);
        long longValue = UNSAFE.getLong(allocatedAddress);
        System.out.println(new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:").append(longValue));

        // free掉，这个数据可能脏读
        UNSAFE.freeMemory(allocatedAddress);
        longValue = UNSAFE.getLong(allocatedAddress);
        System.out.println(new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:").append(longValue));

        /*byte[] data = new byte[10];
        byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset);
        UNSAFE.putByte(data, byteArrayBaseOffset, (byte) 1);
        UNSAFE.putByte(data, byteArrayBaseOffset+5, (byte) 5);
        System.out.println(Arrays.toString(data));

        System.out.println(Test.class.getClassLoader());*/
    }

    public Unsafe getUnsafe() {
        Field f = null;
        Unsafe unsafe = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(null);
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsafe;
    }
}
