package singleton;

public class DclSingleton {
	private static volatile DclSingleton mInstance = null;
//	private static DclSingleton mInstance = null;
    private DclSingleton() {
    }
    public void doSomething() {
        System.out.println("do sth.");
    }
    public static DclSingleton getInstance() {
        // 避免不必要的同步
        if (mInstance == null) {
            // 同步
            synchronized (DclSingleton.class) {
                // 在第一次调用时初始化
                if (mInstance == null) {
                    mInstance = new DclSingleton();
                }
            }
        }
        return mInstance;
    }
}
