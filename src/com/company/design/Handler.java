package com.company.design;

/**
 * 抽象的处理者实现三个职责：一是定义一个请求的处理方法handlerMessahe，唯一对外开发的方法；二是定义一个链的编排方法setNextHandler()，设置下一个处理者；三是定义了具体的请求者必须实现的两个方法：定义自己能够处理的级别getHandlerLevel和具体的处理任务echo()。
 */
public abstract class Handler {
    private Handler nextHandler = null;
    public final Response handleMessage(Request request) {
        Response response = null;
        // 判断是否是自己的处理级别
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {// 不属于自己的处理级别
            // 判断是否有下一个处理者
            if (this.nextHandler != null) {
                response = this.nextHandler.handleMessage(request);
            } else {
                // 没有适当的处理者，业务自行处理
            }
        }
        return  response;
    }
    // 设置下一个处理者是谁
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    // 每个处理者都有一个处理级别
    protected abstract Level getHandlerLevel();
    // 每个处理者都必须实现处理任务
    protected abstract Response echo(Request request);
}
