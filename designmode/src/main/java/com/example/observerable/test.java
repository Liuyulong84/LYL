package observerable;

public class test {
	public static void main(String[] args) {
        // 创建目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 创建观察者对象
        Observer observer = new ConcreteObserver();
        // 将观察者对象注册到目标对象上
        concreteSubject.attach(observer);
        // 改变目标对象的状态
        concreteSubject.change("I change");
    }
}
