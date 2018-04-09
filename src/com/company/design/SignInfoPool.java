package com.company.design;

/**
 * Created by daishuli on 2018/1/22.
 */
public class SignInfoPool extends SignInfo {
    private String key;

    public SignInfoPool(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
