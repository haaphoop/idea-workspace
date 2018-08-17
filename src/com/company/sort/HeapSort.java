package com.company.sort;

/**
 * 堆排序
 * Created by daishuli on 2018/5/24.
 */
public class HeapSort {
    /**
     *  堆排序过程 {6,5,8,1,4,3,2,9}
     *  堆的定义：n个元素的序列{k1,k2,...,kn},当且仅当满足 ki <= k2i 同时，Ki <= K2i+1，即父节点大于左右孩子节点，或同时小于左右孩子节点。
     *  满足同时小于孩子节点的堆称为小顶堆，同时大于孩子节点的堆称为大顶堆。
     *
     */
    static void heapAdjustDown(int[] array, int start, int end) {
        int temp = array[start]; // 取得首节点
        int i = start*2 + 1; // 该节点左孩子位置
        while (i <= end) { // 孩子节点不超过最后节点
            if ((i+1) <= end && array[i+1]>array[i]) // 存在右孩子时，判断左右孩子的大小
                i++;
            if (array[i] < temp) // 如果大孩子节点都小于当前节点，无需继续交换
                break;
            array[start] = array[i];// 将大孩子节点赋值给父节点
            start = i; // 从该孩子节点继续做处理
            i = start*2 + 1;
        }
        array[start] = temp;
    }

    static void heapBuild(int[] array) {
        if (array == null || array.length <= 1)
            return;
        for (int i = (array.length-1)/2; i >=0 ; i--) {
            heapAdjustDown(array, i, array.length-1);
        }
    }

    static void heapSort(int[] array, int start, int end) {
        for (int i = end; i > 0; i--) {
            swap(array, 0, i);
            heapAdjustDown(array, 0, i-1);
        }
    }

    static void swap(int[] array, int i, int j) {
        array[i] = array[i]^array[j];
        array[j] = array[i]^array[j];
        array[i] = array[i]^array[j];
    }

    public static void main(String[] args) {
        int[] array = {28, 26, 17, 36, 20, 42, 11, 53};
        heapBuild(array);
        heapSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
