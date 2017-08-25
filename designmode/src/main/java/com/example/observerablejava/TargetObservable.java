package observerablejava;

import java.util.Observable;

//Observable是被观察者对象接口，实现该接口就是：目标（被观察者）的具体实现
public class TargetObservable extends Observable {
  // 要观察的数据：消息发生改变时，所有被添加的观察者都能收到通知
  private String message;

  public String getConent() {
      return message;
  }

  public void setMessage(String message) {
      this.message = message;
      // 被观察者数据发生变化时，通过以下两行代码通知所有的观察者
      this.setChanged();
      this.notifyObservers(message);
  }
}
