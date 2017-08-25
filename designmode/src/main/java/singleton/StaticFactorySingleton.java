package singleton;

public class StaticFactorySingleton {
	//initailzed during class loading
    private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();
 
    //to prevent creating another instance of Singleton
    private StaticFactorySingleton(){}
 
    public static StaticFactorySingleton getSingleton(){
        return INSTANCE;
    }
}
