package singleton;

public class StaticInnerSingleton {
	private StaticInnerSingleton() {
    }
    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.sInstance;
    }
    // 静态内部类
    private static class SingletonHolder {
        private static final StaticInnerSingleton sInstance = new StaticInnerSingleton();
    }
}
