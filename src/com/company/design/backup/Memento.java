package com.company.design.backup;

import java.util.HashMap;

/**
 * Created by daishuli on 2018/1/23.
 */
public class Memento {
    // 接受hashmap作为状态
    private HashMap<String, Object> stateMap;
    // 接受一个对象，建立一个备份
    public Memento(HashMap<String, Object> stateMap) {
        this.stateMap = stateMap;
    }

    public HashMap<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(HashMap<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}
