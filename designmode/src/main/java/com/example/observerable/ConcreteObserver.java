package observerable;

public class ConcreteObserver implements Observer {

    // 观察者状态
    private String observerState;

    @Override
    public void update(String state) {
        // 更新观察者状态，让它与目标状态一致
        observerState = state;
        System.out.println("ConcreteObserver State :" + observerState);
    }
}
