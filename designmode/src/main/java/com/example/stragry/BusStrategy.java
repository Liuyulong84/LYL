package stragry;

public class BusStrategy implements AbstractStrategy {
    @Override
    public int calculatePrice(int km) {
        int extraTotal = km - 10;
        int extraFactor = extraTotal / 5;
        int fraction = extraTotal % 5;
        int price = 1 + extraTotal % 5;
        return fraction > 0 ? ++price : price;
    }
}

