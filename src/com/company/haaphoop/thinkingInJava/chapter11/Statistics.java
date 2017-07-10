package com.company.haaphoop.thinkingInJava.chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/10 22:52
 * @Modified:
 */
public class Statistics {
    /*
    * 在main()中，自动包装机制将随机生成的int转换为HashMap可以使用的Integer引用（不能使用基本类型的容器）。
    * 如果键不在容器中，get()方法将返回null(这表示该数字第一次被找到)。否则，get()方法将产生与该键相关联的Integer值，然后这个值被递增（
    * 自动包装机制再次简化了表达式，但是确实发生了对Integer的包装盒拆包）。
    * */
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(10);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
