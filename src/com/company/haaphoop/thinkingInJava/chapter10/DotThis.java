package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/6/30.
 */
public class DotThis {
    void f(){System.out.println("DotThis.f()");}
    public class Inner {
        public DotThis outer(){
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner dti = dotThis.inner();
        dti.outer().f();
    }
}

class DotNew {
    public class Inner{
        Inner(){
            System.out.println("create Inner()");
        }
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
