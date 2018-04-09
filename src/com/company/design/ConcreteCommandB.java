package com.company.design;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by daishuli on 2018/1/20.
 */
public class ConcreteCommandB extends Command {
    public ConcreteCommandB(){
        super(new ConcreteReceiveB());
    }
    public ConcreteCommandB(Receive receive) {
        super(receive);
    }
    public void execute(){
        super.receive.doSomething();
    }
}
