package com.company.haaphoop.thinkingInJava.chapter10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: daishuli
 * @Date: Create in 2017/7/4 22:22
 * @Modified:
 */
public class Controller {
    /*
    * 下面的文件包含了一个用来管理并触发事件的实际控制框架。Event对象被保存在List<Event>类型的容器对象中，
    * run()方法循环遍历eventList，寻找就绪的(ready())，要运行的Event对象。对找到的每一个就绪的(ready())事件
    * 使用对象的toString()打印其信息，调用其action()方法，然后从队列中移除此Event事件。
    * */
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event event){ eventList.add(event);}
    public void run(){
        while (eventList.size() > 0) {
            for (Event event : new ArrayList<Event>(eventList)){
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                }
            }
        }

    }
}
