package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class Invoker {
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
