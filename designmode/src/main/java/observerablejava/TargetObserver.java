package observerablejava;

import java.util.Observable;
import java.util.Observer;

//Observer对象是观察者，实现Observer的对象就是具体的观察者对象
public class TargetObserver implements Observer {
  // 定义观察者名称
  private String name;

  public String getObserverName() {
      return name;
  }

  public void setObserverName(String observerName) {
      this.name = observerName;
  }

  @Override
  public void update(Observable arg0, Object arg1) {
      //更新消息数据
      System.out.println(name + "收到了发生变化的数据内容是："
              + ((TargetObservable) arg0).getConent());
  }
}
