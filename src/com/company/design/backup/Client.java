package com.company.design.backup;

/**
 * Created by daishuli on 2018/1/23.
 */
public class Client {
    public static void main(String[] args) {
        // 定义发起人
        Originator originator = new Originator();
        // 定义备忘录管理员
        Caretaker caretaker = new Caretaker();
        //originator.setState1("中国");
        //originator.setState2("强盛");
        //originator.setState3("繁荣");
        System.out.println("初始化状态: \n" + originator);

        // 创建两个备忘录
        /**caretaker.setMemento("001", originator.createMemento());
        originator.setState1("软件");
        originator.setState1("架构");
        originator.setState1("优秀");
        caretaker.setMemento("002", originator.createMemento());
        originator.setState1("中国1");
        originator.setState2("强盛2");
        originator.setState3("繁荣3");
        caretaker.setMemento("003", originator.createMemento());
        originator.setState1("中国2");
        originator.setState2("强盛3");
        originator.setState3("繁荣4");
        caretaker.setMemento("004", originator.createMemento());
        // 恢复一个指定的备忘录
        originator.restoreOriginator(caretaker.getMemento("003"));
        System.out.println("恢复后状态： \n" + originator);**/
    }
}
