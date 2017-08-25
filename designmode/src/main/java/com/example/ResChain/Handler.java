package ResChain;

public abstract class Handler {
    private Handler nextHandler;
    // 当前领导能审批通过的最多天数
    public int maxDay;
    protected Handler(int maxDay) {
        this.maxDay = maxDay;
    }
    //设置责任链中下一个处理请求的对象
    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }
    protected void handleRequest(int day) {
        if (day <= maxDay) {
            reply(day);
        } else {
            if (nextHandler != null) {
                //审批权限不够，继续上报
                nextHandler.handleRequest(day);
            } else {
            	System.out.println("没有更高的领导审批了");
            }
        }
    }
    protected abstract void reply(int day);
}
