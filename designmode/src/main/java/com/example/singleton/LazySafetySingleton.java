package singleton;

public class LazySafetySingleton {
	private static LazySafetySingleton instance;  
    private LazySafetySingleton (){
    }
    
    public static void createString(){
   	 System.out.println("create String");
    }
   	  
   public static void main(String[] args){
   	 LazySingleton.createString();
   }
   
   //方法中声明synchronized关键字
   public static synchronized LazySafetySingleton getInstance() {
	 if (instance == null) {  
         instance = new LazySafetySingleton();  
     }  
     return instance;  
   }
   
   //同步代码块实现
   public static LazySafetySingleton getInstance1() {  
           synchronized (LazySafetySingleton.class) {  
               if(instance == null){//懒汉式   
                   instance = new LazySafetySingleton();  
               }  
           }  
       return instance;  
   }  
}
