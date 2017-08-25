package factoryMethod;

class ConcreteProductA extends Product {  
     
	public ConcreteProductA(){
		System.out.println("创建了A");
	}
    public void methodDiff() {  
    	System.out.println("A的工作");  
    }  
}