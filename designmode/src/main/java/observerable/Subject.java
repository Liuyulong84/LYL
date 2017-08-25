package observerable;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标者
 */
public abstract class Subject {

    // 保存注册的观察者对象
    private List<Observer> mObservers = new ArrayList<>();

    //注册观察者对象
    public void attach(Observer observer) {
        mObservers.add(observer);
        System.out.println("Attached an observer");
    }

    //注销观察者对象
    public void detach(Observer observer) {
        mObservers.remove(observer);
    }

    // 通知所有注册的观察者对象
    public void nodifyObservers(String newState) {
        for (Observer observer : mObservers) {
            observer.update(newState);
        }
    }
}