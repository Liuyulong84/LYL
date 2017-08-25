package observerablejava;

import java.util.Observable;
import java.util.Observer;

public class TargetObserver01 implements Observer {
    // 定义观察者名称
    private String name01;

    public String getObserverName() {
        return name01;
    }

    public void setObserverName(String observerName) {
        this.name01 = observerName;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        //更新消息数据
        System.out.println(name01 + "收到了发生变化的数据内容是："
                + ((TargetObservable) arg0).getConent());
    }
}
