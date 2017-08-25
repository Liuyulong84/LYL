package decorator;

class ConcreteDecorator extends Decorator
{
       public ConcreteDecorator(Component  component)
       {
              super(component);
       }

       public void operation()
       {
              super.operation();  //调用原有业务方法
              addedBehavior();  //调用新增业务方法
       }

     //新增业务方法
       public  void addedBehavior()
       {    
        //todo
       }
}
