package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/9.
 */
public class DefaultStrategy implements Strategy {
    @Override
    public boolean equal(Object obj1, Object obj2) {
        if (obj1.equals(obj2)) {
            return true;
        }
        return false;
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        Integer integer1 = (Integer) obj1;
        Integer integer2 = (Integer) obj2;
        return integer1.compareTo(integer2);
    }
}
