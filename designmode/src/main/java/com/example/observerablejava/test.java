package observerablejava;

public class test {
	public static void main(String[] args) {
        // 创建一个具体的被 观察者
        TargetObservable observable = new TargetObservable();
        // 创建第一个观察者
        TargetObserver one = new TargetObserver();
        one.setObserverName("我是观察者A");
        // 创建第二个观察者
        TargetObserver01 two = new TargetObserver01();
        two.setObserverName("我是观察者B");
        // 注册观察者
        observable.addObserver(one);
        observable.addObserver(two);
        // 目标更新天气情况
        observable.setMessage("***我要更新的数据***");
    }
}
