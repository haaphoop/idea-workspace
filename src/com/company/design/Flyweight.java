package com.company.design;

/**
 * Created by daishuli on 2018/1/22.
 */
public abstract class Flyweight {
    // 内部状态
    private String intrinsic;
    // 外部状态
    protected final String extrinsic;
    // 要求享元角色必须接收外部状态
    public Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    // 定义业务操作
    public abstract void operation();

    // 内部状态的getter/setter方法
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
