package com.company.datastructure;

/**
 * Created by daishuli on 2018/4/9.
 */
public class DefaultStrategy implements Strategy {
    @Override
    public boolean equal(Object obj1, Object obj2) {
        return false;
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        return 0;
    }
}
