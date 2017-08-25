package singleton;

public class LazySingleton {
	private static LazySingleton instance;
    private LazySingleton() {
    }
    public static LazySingleton getInstance() {
        // 第一次调用的时候会被初始化
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
    
    public static void createString(){
    	 System.out.println("create String");
    }
    	  
    public static void main(String[] args){
    	 LazySingleton.createString();
    }
}
