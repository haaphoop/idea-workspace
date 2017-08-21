package com.company.haaphoop.thinkingInJava.chapter15;

import com.company.commonUtils.GenericUtils;

import java.util.List;
import java.util.Map;

public class LimitsOfInterface {
    static void f(Map<String, List<? extends LimitsOfInterface>> l) {

    }

    public static void main(String[] args) {
        Map<String, List<? extends LimitsOfInterface>> ll = GenericUtils.map();
        //f(GenericUtils.map());  //Does not compile
        f(ll);
    }
}
