package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Created by daishuli on 2018/4/16.
 */
public class GenUUId implements Callable {
    @Override
    public Object call() throws Exception {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            set.add(getUUID());
        }
        return set;
    }

    private String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
