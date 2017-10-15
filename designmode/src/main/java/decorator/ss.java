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
    }
}
