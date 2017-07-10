package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 21:12
 * @Modified:
 */
public class ListIteration {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(8);
        Collections.addAll(list,"Rat","Manx", "Cymric","Mutt", "Pug", "Cymric", "Pug", "Manx");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "," + listIterator.nextIndex() + ", " + listIterator.previousIndex() + "===");
        }

        System.out.println();

        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }

        System.out.println();
        System.out.println(list);

        listIterator = list.listIterator(2);
        while(listIterator.hasNext()) {
            listIterator.next();
            listIterator.set("daddd");
        }

        System.out.println(list);
    }
}
