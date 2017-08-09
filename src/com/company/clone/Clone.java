package com.company.clone;

import java.io.Serializable;

/**
 * Created by daishuli on 2017/8/9.
 */
public class Clone implements Cloneable,Serializable {
    Child child;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Clone clone = new Clone();
        Child child = new Child();
        child.c = 10;
        child.p = 5;
        clone.child = child;
        Clone clone1 = (Clone) clone.clone();
        System.out.println(clone.child == clone1.child);
    }
}
