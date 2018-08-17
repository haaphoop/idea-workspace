package com.company.interview;

/**
 * Created by daishuli on 2018/8/16.
 */
public class Class1 {
    static boolean print(int i) {
        System.out.println(i);
        return true;
    }
     public static void main(String[] args) {
         System.out.println("---java跳出多重循环的几种方式------");
         int i = 10, j = 10,index = 0, m=0;
         skip:
         for (; index < i; index++){
             for (m = index; m < j; m++){
                 if (index == 6 && m == 9) {
                     break skip;
                 }
             }
         }
         System.out.println("index= "+index + " m= " + m);

         j = 1;
         /*for (print(1); print(2) && j<4; print(3)) {
             System.out.println("do something");
            j++;
         }*/

         do {
             System.out.println("do something "+ j);
             j++;
         }while (print(2) && j<0);

         System.out.println(j);
    }
}
