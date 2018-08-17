package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by daishuli on 2018/5/15.
 */
public class DailyTest {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        /*if (matrix == null)
            return null;
        int lastI = (matrix.length - 1) / 2;
        if (matrix.length <= 2)
            lastI = 1;
        int lastJ = (matrix[0].length - 1) /2;
        int iMin =0, jMin =0, iMax = matrix.length - 1, jMax = matrix[0].length - 1;
        int i=iMin, j=jMin;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (i<=iMax && i>= iMin && j <=jMax && j>=jMin) {
            list.add(matrix[i][j]);
            // 从左向右打印
            if (j != jMax && i == iMin) {
                j++;
            } else if (j == jMax && i != iMax) { // 从上向下打印
                i++;
            } else if (j != jMin && i == iMax) { // 从右向左打印
                j--;
            } else if (j == jMin && i != iMin) { // 从下向上打印
                i--;
            }
            if (j == jMin && i == iMin) {
                iMax = iMax - 1;
                iMin = iMin + 1;
                jMax = jMax - 1;
                jMin = jMin + 1;
                // 继续下一次循环
                j++;
                i++;
            }
            if (iMin > iMax || jMin > jMax) {
                break;
            }
        }*/
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0, right = matrix.length-1, top = 0, bottom = matrix[0].length-1;
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int i= left; i<= right; i++)
                list.add(matrix[top][i]);
            // 从上到下
            for (int i=top+1; i<=bottom; i++)
                list.add(matrix[i][right]);
            // 从右到左
            if (top != bottom)
                for (int i=right-1; i>=left;i--)
                    list.add(matrix[bottom][i]);
            // 从下到上
            if (left != right)
                for (int i=bottom-1; i>top; i--)
                    list.add(matrix[i][left]);

            left++;top++;bottom--;right--;
        }
        return list;
    }

    public static void main(String[] args) {
        /**int[][] array = {{1},{5},{9},{13},{17}};
        int[] element = new int[10];
        for (int i = 0; i < 10; i++) {
            element[i]=i;
        }
        int[] temp = new int[element.length*2];
        System.arraycopy(element,0, temp, 0,element.length);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }**/
        //System.out.println(printMatrix(array));
        //Thread
        int[] array1 = {10,8,5,9,11,1,4,12,7};
        quickSort(array1, 0, array1.length-1);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]+" ");
        }
    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <=1)
            return;
        for (int i = 0; i < array.length; i++) {
            boolean swapAble = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    swapAble = true;
                    array[j] = array[j]^array[j+1];
                    array[j+1] = array[j]^array[j+1];
                    array[j] = array[j]^array[j+1];
                }
            }
            if (!swapAble){
                break;
            }
            for (int h = 0; i < array.length; h++) {
                System.out.print(array[h]+" ");
            }
            System.out.println();
        }
    }

    static void cocktailSort(int[] array) {
        if (array == null || array.length <=1)
            return;
        int low = 0, high = array.length-1;
        while (low < high) {
            for (int i = low; i < high; i++) {
                if (array[i] > array[i+1]){
                    array[i] = array[i]^array[i+1];
                    array[i+1] = array[i]^array[i+1];
                    array[i] = array[i]^array[i+1];
                }
            }
            high--;
            for (int i = high; i >low ; i--) {
                if (array[i-1]>array[i]) {
                    array[i-1] = array[i-1]^array[i];
                    array[i] = array[i-1]^array[i];
                    array[i-1] = array[i-1]^array[i];
                }
            }

            low++;
        }
    }

    static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length <=1 || low >= high || array.length < high || low < 0)
            return;

        int currentLow = low, currentHigh = high;
        int pivot = array[currentHigh];
        while (currentLow < currentHigh) {
            while (currentLow<currentHigh && pivot >= array[currentLow])
                currentLow++;
            array[currentHigh]=array[currentLow];
            while (currentLow<currentHigh && pivot <= array[currentHigh])
                currentHigh--;
            array[currentLow]=array[currentHigh];
        }
        array[currentLow] = pivot;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        quickSort(array, low, currentLow-1);
        quickSort(array, currentLow+1, high);
    }
}
