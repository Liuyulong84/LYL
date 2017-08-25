package singleton;

public class HungurySingleton {
	private static final HungurySingleton mHungurySingleton = new HungurySingleton();
	private HungurySingleton(){
		System.out.println("Singleton is create");
		
	}
    public static HungurySingleton getHungurySingleton() {
        return mHungurySingleton;
    }
    
    public static void createString(){
    	 System.out.println("createString in Singleton");
    }
    	  
    public static void main(String[] args){
    	HungurySingleton.createString();
    }
}
