package com.company.haaphoop.thinkingInJava.chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by daishuli on 2017/8/30.
 */
public class CollectionMethods {

    /*
    * 创建ArrayList来保存不同的数据集，然后向上转型为Collection，所以很明显，代码只用到了Collection接口。main()用简单的练习展示了Collection中的所有方法。
    * */
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<String>();
        //collection.addAll();
        collection.add("ten");
        collection.add("eleven");
        System.out.println(collection);
        Object[] array = collection.toArray();
        String[] str = collection.toArray(new String[0]);
        System.out.println(Arrays.toString(str));
        System.out.println(Collections.max(collection));
        System.out.println(Collections.min(collection));
    }
}
