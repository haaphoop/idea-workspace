package com.company.datastructure.string;

/**
 * Created by daishuli on 2018/4/16.
 */
public class StringFirstCharacter {
    String [] strings;

    public static void main(String[] args) {
        StringFirstCharacter ss = new StringFirstCharacter();
        ss.strings = new String[]{"American", "Japan","China", "France","Brazil", "americam","Americaa", "Americac","Americanddd", "Americandde","American1"};
        ss.characterQuickSorted(ss.strings, 0, ss.strings.length-1);
        for (String s: ss.strings) {
            System.out.print(s+":");
        }
    }

    /**
     * 冒泡排序
     */
    private void characterBubbleSorted() {
        if (strings == null || strings.length <= 1)
            return;
        for (int i = 0; i < strings.length; i++) {
            for (int j = i; j < strings.length; j++) {
                if ("second".equals(equals(strings[i], strings[j]))) {
                    String temp = strings[j];
                    strings[j] = strings[i];
                    strings[i] = temp;
                }
            }
        }
    }

    /**
     * 直接插入排序
     * 参数delta是插入间隔，默认为1，即直接插入排序，当delta作为一个数组如{5,3,1}时，就为希尔排序
     */
    public void characterInsertSorted(int delta) {
        if (strings == null || strings.length <= 1)
            return;
        for (int i = 0+delta; i < strings.length; i++) {
            String key = strings[i];
            int j = i-delta;
            while (j < i && j>=0) {
                if ("first".equals(equals(key, strings[j]))) {
                    strings[j+delta] = strings[j];
                    j = j - delta;
                } else {
                    break;
                }
            }
            strings[j+delta] = key;
        }
    }

    /**
     * 折半排序
     */
    public void characterBinInsertSorted() {
        if (strings == null || strings.length <= 1)
            return;
        for (int i = 1; i < strings.length; i++) {
            String key = strings[i];
            int high = i-1, low = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if ("first".equals(equals(key, strings[mid]))) {
                    high = mid - 1;
                } else if ("second".equals(equals(key, strings[mid]))){
                    low = mid + 1;
                }
            }
            int j = i;
            while (j > low) {
                strings[j] = strings[j - 1];
                j--;
            }
            strings[high+1] = key;
        }
    }

    /**
     * 希尔排序
     */
    public void characterShellSorted(int[] deptK) {
        if (strings == null || strings.length <= 1)
            return;
        for (int i = 0; i < deptK.length; i++) {
            characterInsertSorted(deptK[i]);
        }
    }

    /**
     * 快速排序:通过枢纽pivot，将数组分为Lr和Ll，再分别对Lr和Ll进行划分；直至只有一个元素无法再进行划分。
     */
    public void characterQuickSorted(String[] strings, int low, int high) {
        if (low >= high) {
            return;
        }
        int newLow = low;
        int newHigh = high;
        String pivot = strings[low];
        while (newLow < newHigh) {
            while (newLow < newHigh && "first".equals(equals(strings[newHigh], pivot)))
                newHigh--;
            strings[low] = strings[newHigh];
            while (newLow < newHigh && "second".equals(equals(strings[newLow], pivot)))
                newLow++;
            strings[newHigh] = strings[newLow];
        }
        strings[newLow] = pivot;
        characterQuickSorted(strings, low, newLow-1);
        characterQuickSorted(strings, newLow+1, high);
    }

    /**
     *  比较两个字符串大小：
     *      参数为null或长度为0时返回empty;
     *      string1 < string2时返回first；
     *      string1 >string2时返回second；
     *      string1 = string2时，返回second
     * @param string1
     * @param string2
     * @return
     */
    private String equals(String string1, String string2) {
        if (string1 == null || string2 == null || string1.length() == 0 || string2.length() == 0)
            return "empty";
        int i = 0;
        while (i < string1.length() && i<string2.length()) {
            if (string1.charAt(i) == string2.charAt(i)) {
                i++;
            } else if (string1.charAt(i) < string2.charAt(i)) {
                return "first";
            } else {
                return "second";
            }
        }
        if (i == string1.length() && i != string2.length()) {
            return "first";
        } else if (i == string2.length() && i != string1.length()) {
            return "second";
        } else {
            return "same";
        }
    }
}
