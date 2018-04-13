package com.company.datastructure.sort;

/**
 * Created by daishuli on 2018/4/13.
 */
public class Sorted<T> {
    private Strategy strategy;

    public Sorted(Strategy strategy) {
        this.strategy = strategy;
    }

    public Sorted() {
        this.strategy = new DefaultStrategy<T>();
    }

    public static void main(String[] args) {
        Sorted<Integer> sorted = new Sorted<Integer>();
        Integer[] integers = new Integer[8];
        integers[0] = 26;
        integers[1] = 53;
        integers[2] = 48;
        integers[3] = 11;
        integers[4] = 13;
        integers[5] = 48;
        integers[6] = 32;
        integers[7] = 15;
        System.out.println("排序前:");
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+":");
        }
        System.out.println();
        sorted.binInsertSort(integers);
        System.out.println("排序后:");
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+":");
        }
    }

    /**
     * 直接插入排序:仅有一个元素的序列总是有序的，因此，对n个记录的序列，可从第二个元素开始直到第n个元素，逐个向有序序列中执行插入操作，从而得到n个元素按关键字有序的序列。
     *  {26,53,48,11,13,48,32,15}
     * @param ts
     */
    public void insertSorted(T[] ts) {
        if(ts == null || ts.length <= 1)
            return;
        T temp = null;
        for (int i = 1; i < ts.length; i++) {
            int j = i;
            temp = ts[i];
            if (strategy.compare(temp, ts[j-1]) < 0) { // 第n个元素比前n-1个有序序列最后一个元素小的时候，才需要逐个比较，如果比第n-1个元素大，说明，不需要再向前比较。直接进行n+1
                for (; j > 0 && strategy.compare(temp, ts[j-1]) < 0; j--) {
                        ts[j] = ts[j-1];
                }
                ts[j] = temp;
            }
        }
    }

    /**
     * 折半插入排序
     * @param ts
     */
    public void binInsertSort(T[] ts) {
        if(ts == null || ts.length <= 1)
            return;
        T temp = null;
        for (int i = 1; i < ts.length; i++) {
            temp = ts[i];
            if (strategy.compare(ts[i-1], temp) > 0) {
                int low = 0, high = i-1, mid;
                while (low <= high) {
                     mid = (low + high) / 2;
                    if (strategy.compare(ts[mid], temp) < 0) {
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
                /*for (int k = i-1; k > high ; k--) {
                    ts[k+1] = ts[k];
                }*/
                int j = i;
                while (j> (high+1)) {
                    ts[j] = ts[--j];
                }
                ts[high+1] = temp;
            }
        }
    }
}
