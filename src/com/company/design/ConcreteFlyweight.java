package com.company.design;

/**
 * Created by daishuli on 2018/1/22.
 */
public class ConcreteFlyweight extends Flyweight {
    // 接受外部状态
    public ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }
    // 根据外部状态进行逻辑处理
    @Override
    public void operation() {

    }
}
