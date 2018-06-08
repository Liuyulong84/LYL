package decorator;

/**
 * Created by $lyl on 2017/10/14.
 */

public class ss {
    public static void main(String[] args) {
        Decorator decorator = new Decorator(new Component() {
            @Override
            public void operation() {
                System.out.println("Component");
            }
        });
        decorator.operation();

        System.out.println("----------------");

        ConcreteDecorator concreteDecorator = new ConcreteDecorator(new Component() {
            @Override
            public void operation() {
                System.out.println("Component");
            }
        });

        concreteDecorator.operation();
    }
    //Decorator 装饰模式
}
