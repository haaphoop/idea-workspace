package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public abstract class Command {
    // 子类共享全局变量
    protected final Receive receive;
    public Command(Receive receive){
        this.receive = receive;
    }
    public abstract void execute();
}
