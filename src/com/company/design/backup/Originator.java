package com.company.design.backup;

import com.company.clone.BeanUtil;

/**
 * Created by daishuli on 2018/1/23.
 */
public class Originator{
    private String state;

    // 创建一个备忘录对象
    public Memento createMemento(){
        return new Memento(this.state);
    }
    // 恢复一个备忘录
    public void restoreOriginator(IMemento memento){
        this.setState(((Memento)memento).getState());
    }

    // 内部类
    private class Memento implements IMemento {
        // 发起人内部状态
        private String state = "";
        private Memento(String state) {
            this.state = state;
        }
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
