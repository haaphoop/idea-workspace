package com.company.design.mediator;

/**
 * Created by daishuli on 2018/1/22.
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
