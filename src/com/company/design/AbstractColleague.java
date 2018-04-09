package com.company.design;

/**
 * Created by daishuli on 2018/1/22.
 */
public abstract class AbstractColleague {
    protected  AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
