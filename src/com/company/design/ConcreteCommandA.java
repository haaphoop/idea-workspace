package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
public class ConcreteCommandA extends Command {
    public ConcreteCommandA(){
        super(new ConcreteReceiveA());
    }

    public ConcreteCommandA(Receive receive) {
        super(receive);
    }
    public void execute(){
        super.receive.doSomething();
    }
}
