package stragry;

public class Context {

    //策略模式
    private AbstractStrategy strategy;

    public void setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public int calclatePrice(int km) {
        return strategy.calculatePrice(km);
    }

    public static void main(String[] strings) {
        Context calculator = new Context();
        calculator.setStrategy(new BusStrategy());
//        calculator.setStrategy(new TaxiStrategy());
        System.out.println("公交车20km价格：" + calculator.calclatePrice(20));
    }

}
