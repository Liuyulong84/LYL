package factoryMethod;

abstract class Product {  
    //所有产品类的公共业务方法  
    public void methodSame() {  
    	System.out.println("所有相同的工作"); 
    }  

    //声明抽象业务方法  
    public abstract void methodDiff();  
}
