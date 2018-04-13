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
        integers[0] = 34;
        integers[1] = 2;
        integers[2] = 1;
        integers[3] = 14;
        integers[4] = 5;
        integers[5] = 16;
        integers[6] = 7;
        integers[7] = 3;
        System.out.println("排序前:");
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+":");
        }
        System.out.println();
        /*sorted.binInsertSort(integers);
        System.out.println("排序后:");
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+":");
        }*/

        /*System.out.println("快速排序后:");
        sorted.quickSort(integers, 0, 7);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i]+":");
        }*/

        System.out.println("简单选择排序后:");
        sorted.selectedSort(integers);
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

    /**
     * 希尔排序
     *
     */
    public void shellSort(T[] ts, int low, int high, int[] delta) {
        for (int i = 0; i < delta.length; i++) {
            shellInsert(ts, low, high, delta[i]);
        }
    }

    private void shellInsert(T[] ts, int low, int high, int deltaK) {
        for (int i = low+deltaK; i <= high; i++) {
            if (strategy.compare(ts[i], ts[i-deltaK]) < 0) {
                T temp = ts[i];
                int j = i - deltaK;
                for (; j>low && strategy.compare(temp, ts[j]) < 0 ; j=j - deltaK) {
                    ts[j+deltaK] = ts[j];
                }
                ts[j+deltaK] = temp;
            }
        }
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(T[] ts, int low, int high) {
        int n = high - low + 1;
        for (int i = 1; i < n; i++) {
            for (int j = low; j <= high-i; j++) {
                if (strategy.compare(ts[j], ts[j+1]) > 0) {
                    T temp = ts[j];
                    ts[j] = ts[j+1];
                    ts[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     */
    public void quickSort(T[] ts, int low, int high) {
        if (low >= high)
            return;
        T pivot = ts[low];
        int currentLow = low, currentHigh = high;
        while (currentLow < currentHigh) {
            while (currentLow < currentHigh && strategy.compare(ts[currentHigh], pivot) >= 0)
                currentHigh--;
            ts[currentLow] = ts[currentHigh];
            while (currentLow < currentHigh && strategy.compare(ts[currentLow], pivot) <= 0)
                currentLow++;
            ts[currentHigh] = ts[currentLow];
        }
        ts[currentLow] = pivot;
        quickSort(ts, low, currentLow-1);
        quickSort(ts, currentLow+1, high);
    }

    /**
     * 简单选择排序
     * @param ts
     */
    public void selectedSort(T[] ts) {
        for (int i = 0; i < ts.length; i++) {
            int temp = i, j = i+1;
            while (j < ts.length) {
                if (strategy.compare(ts[temp], ts[j]) > 0){
                    temp = j;
                }
                j++;
            }
            if (i != temp) {
                T t = ts[temp];
                ts[temp] = ts[i];
                ts[i] = t;
            }
        }
    }
}
