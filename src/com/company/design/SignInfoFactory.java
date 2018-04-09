package com.company.design;

import java.util.HashMap;

/**
 * Created by daishuli on 2018/1/22.
 */
public class SignInfoFactory {
    private static HashMap<String, SignInfo> pool = new HashMap<String, SignInfo>();
    public static SignInfo getSignInfo(String key) {
        SignInfo result = null;
        if (!pool.containsKey(key)) {
            System.out.println(key + "--建立对象，并放入池中");
            //result = new SignInfoPool(key);
            result = new SignInfo();
            pool.put(key, result);
        } else {
            result = pool.get(key);
            System.out.println(key + "--直接从池中获取");
        }
        return result;
    }
}
