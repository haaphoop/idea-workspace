package com.company.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by daishuli on 2018/4/25.
 */
public class UnsafeTest {
    private static int byteArrayBaseOffset;

    public static void main(String[] args) throws NoSuchFieldException,IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = (Unsafe)theUnsafe.get(null);
        System.out.println(UNSAFE);
        AtomicInteger integer = new AtomicInteger(0);
        integer.getAndAdd(0x61c88647);
        System.out.println(integer);
        integer.getAndAdd(0x61c88647);
        System.out.println(integer);
        integer.getAndAdd(0x61c88647);
        System.out.println(integer);
        integer.getAndAdd(0x61c88647);
        System.out.println(integer);
       /* Field f = null;
        try {
            f = Sampleclass.class.getDeclaredField("i");
        } catch (NoSuchFieldException e) {

        }
        Sampleclass sampleclass = new Sampleclass();
        long s1=System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            sampleclass.setI(i);
        }
        System.out.println(System.currentTimeMillis()-s1);
        Field filed = sampleclass.getClass().getDeclaredField("i");
        long ageOffset = UNSAFE.objectFieldOffset(filed);
        long s2=System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            UNSAFE.putInt(sampleclass, ageOffset, i);
        }
        System.out.println(System.currentTimeMillis()-s2);*/
/*


        // 获取在对象对应的类中的偏移地址
        long iFieldAddressShift = UNSAFE.objectFieldOffset(f);
        Sampleclass sampleclass = new Sampleclass();
        long s1=System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            sampleclass.setI(i);
        }
        System.out.println(System.currentTimeMillis()-s1);

        // 获取对象的偏移地址，需要将目标对象设为辅助数组的第一个元素（也是唯一的元素）。由于这是一个复杂类型元素（不是基本数据类型），它的地址存储在数组的第一个元素。然后获取辅助数组的基本偏移量。数组的基本偏移量是指数组对象的起始地址与数组第一个元素之间的偏移量。
        //Object arrayObject[] = new Object[1];
        //arrayObject[0] = sampleclass;
        //long baseOffset = UNSAFE.arrayBaseOffset(Object[].class);
        //long addressOfSamplessClass = UNSAFE.getLong(arrayObject, baseOffset);
        //UNSAFE.putInt(addressOfSamplessClass+iFieldAddressShift, 100);
        //int i = UNSAFE.getInt(addressOfSamplessClass+iFieldAddressShift);
        long s2=System.currentTimeMillis();
        for(int j=0;j<100000;j++){
            UNSAFE.putInt(sampleclass, iFieldAddressShift, j);
        }
        System.out.println(System.currentTimeMillis()-s2);*/
        //System.out.println(new StringBuilder().append(" Field I Address:").append(addressOfSamplessClass).append("+").append(iFieldAddressShift).append(" Value:").append(i));
        /*// 在堆外分配一个byte
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
        System.out.println(new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:").append(longValue));*/

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
