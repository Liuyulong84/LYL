package factoryMethod;

class ConcreteFactory implements Factory {  
    public Product factoryMethod() {  
        return new ConcreteProductA();  
    }  
}
