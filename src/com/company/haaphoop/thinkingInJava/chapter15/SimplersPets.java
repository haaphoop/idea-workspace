package com.company.haaphoop.thinkingInJava.chapter15;

import com.company.commonUtils.GenericUtils;
import sun.net.www.content.text.Generic;

import java.util.List;
import java.util.Map;

public class SimplersPets {
    public static void main(String[] args) {
        Map<String, List<? extends SimplersPets>> simple = GenericUtils.map();
    }
}
