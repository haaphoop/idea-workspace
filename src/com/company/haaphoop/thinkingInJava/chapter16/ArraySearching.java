package com.company.haaphoop.thinkingInJava.chapter16;

import com.company.haaphoop.thinkingInJava.chapter15.Generator;

import java.util.Arrays;
/*
* 在while循环中随机生成一些值作为查找对象，直到找到一个才停止循环。
* 如果找到了目标，Arrays.binarySearch()产生得返回值等于或大于0.否则，它产生
* 负返回值，表示若要保持数组得排序状态此目标元素所应该插入得位置。这个负值得计算方式是：-(插入点) -1
* 插入点是指，第一个大于查找对象得元素在数组中得位置，如果数组中所有得元素都小于要查找得对象，插入点就等于a.size();
*
* 如果数组包含重复得元素，则无法保证找到得是这些副本中得哪一个。搜索算法确实不是专为包含重复元素得数组而设计得，不过仍然可用。如果需要对没有重复元素得数组排序，可以使用TreeSet（保持排序顺序），或者LinkedHashSet（保持插入顺序），后面不需要自己维护数组。
*   如果使用Comparator排序了某个对象数组，在使用binarySearch()时必须提供同样得Comparator。
*   * */
public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> generator = new RandomGenerator.Integer(1000);
        int[] a = ConverTo.primitive(Generated.array(new Integer[25], generator));
        Arrays.sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));
        while (true) {
            int r = generator.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                System.out.println("Location of " + r + " is " + location
                    + ", a[" + location + "] = " + a[location]);
                break;
            }
            System.out.println("r = "+ r + " location = " + location);
        }
    }
}
