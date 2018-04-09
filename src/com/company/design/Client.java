package com.company.design;

/**
 * Created by daishuli on 2018/1/20.
 */
class MultiThread extends Thread {
    private SignInfo signInfo;

    public MultiThread(SignInfo signInfo) {
        this.signInfo = signInfo;
    }

    @Override
    public void run() {
        if (!this.signInfo.getId().equals(this.signInfo.getLocation())) {
            System.out.println("编号：" + this.signInfo.getId());
            System.out.println("考试地点：" + this.signInfo.getLocation());
            System.out.println("线程不安全");
        }
    }
}
public class Client {
    public static void main(String[] args) {
        SignInfoFactory.getSignInfo("科目1");
        SignInfoFactory.getSignInfo("科目2");
        SignInfoFactory.getSignInfo("科目3");
        SignInfoFactory.getSignInfo("科目4");

        SignInfo signInfo = SignInfoFactory.getSignInfo("科目2");
        while (true) {
            signInfo.setId("zhangsan");
            signInfo.setLocation("zhangsan");
            (new MultiThread(signInfo)).start();
            signInfo.setId("lisi");
            signInfo.setLocation("lisi");
            (new MultiThread(signInfo)).start();
        }

    }

   /* public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            String subject = "科目" + i;
            for (int j = 0; j < 300; j++) {
                String key = subject+ "考试地点" + j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");

        //signInfo.setId("1111");
        new Thread(){
            @Override
            public void run() {
                SignInfo signInfo1 = SignInfoFactory.getSignInfo("科目1考试地点1");
                signInfo1.setId("11112");
                System.out.println("Thread1: " + signInfo1.getId());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                SignInfo signInfo1 = SignInfoFactory.getSignInfo("科目1考试地点1");
                signInfo1.setId("3");
                System.out.println("Thread2: " + signInfo1.getId());
            }
        }.start();
       // System.out.println(signInfo == signInfo1);

        System.out.println("主线程: " + signInfo.getId());
    }*/
    
    /*public static void main(String[] args) {
        // 声明所有的处理节点
        Handler handler1 = new ConcreHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        // 设置链中的阶段顺序 1-->2-->3
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        // 提交请求，返回结果
        Response response = handler1.handleMessage(new Request());
    }*/

    /*public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClassA();
        AbstractClass abstractClass1 = new ConcreteClassB();
        abstractClass.templateMethod();
        abstractClass1.templateMethod();
    }*/

    /*public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();
        Target target1 = new Adapter();
        target1.request();
    }*/

        /*public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receive receive = new ConcreteReceiveA();
        Command  command = new ConcreteCommandA(receive);
        invoker.setCommand(command);
        invoker.action();
    }*/
}
