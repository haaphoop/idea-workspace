package com.company.datastructure.sort;

/**
 * Created by daishuli on 2018/4/13.
 */
public class DefaultStrategy<T> implements Strategy<T> {
    @Override
    public boolean equal(T obj1, T obj2) {
        if (obj1.equals(obj2))
            return true;
        return false;
    }

    @Override
    public int compare(T obj1, T obj2) {
        Integer integer1 = (Integer)obj1;
        Integer integer2 = (Integer)obj2;
        if (integer1.intValue() > integer2.intValue())
            return 1;
        else if (integer1.intValue() == integer2.intValue()) {
            return 0;
        } else
            return -1;
    }
}
