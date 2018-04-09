package com.company.design.backup;

/**
 * Created by daishuli on 2018/1/23.
 */
public class Caretaker {
    private IMemento iMemento;
    public IMemento getMemento() {
        return this.iMemento;
    }

    public void setMemento(IMemento iMemento) {
        this.iMemento = iMemento;
    }
}
