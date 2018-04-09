package com.company.design;

/**
 * Created by daishuli on 2018/1/22.
 */
public abstract class AbstractMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;
    public AbstractMediator() {
        this.purchase = new Purchase(this);
        this.sale = new Sale(this);
        this.stock = new Stock(this);
    }

    public abstract void execute(String str, Object ...objects);
}
