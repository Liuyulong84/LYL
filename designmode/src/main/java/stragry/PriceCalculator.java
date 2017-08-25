package stragry;

public class PriceCalculator {

    private static final int BUS = 1;
    private static final int SUBWAY = 2;

    public static void main(String[] strings) {
        PriceCalculator calculator = new PriceCalculator();
        System.out.println("做20km公交票价：" + calculator.calculatePrice(20, BUS));
        System.out.println("做20km地铁票价：" + calculator.calculatePrice(20, SUBWAY));

    }


    /**
     * 公交车计价    10公里之内1块钱，超过10公里每加一块可以乘5公里
     *
     * @param km
     * @return
     */
    private int busPrice(int km) {
        //超过10公里的距离
        int extraTotal = km - 10;
        //超过距离是5km的倍数
        int extraFactor = extraTotal / 5;
        //超过的距离对5km取余
        int fraction = extraTotal % 5;
        //价格计算
        int price = 1 + extraFactor % 5;
        return fraction > 0 ? ++price : price;
    }

    /**
     * 6km内3块，6—12km是4块，12—22km是5块，22-32km是6块,其他距离7块
     *
     * @param km
     * @return
     */
    public int subwayPrice(int km) {
        if (km <= 6) {
            return 3;
        } else if (km > 6 && km < 12) {
            return 4;
        } else if (km > 12 && km < 22) {
            return 5;
        } else if (km > 22 && km < 32) {
            return 6;
        }
        return 7;
    }

    /**
     * 根据不同类型计算
     *
     * @param km
     * @param type
     * @return
     */
    int calculatePrice(int km, int type) {
        if (type == BUS) {
            return busPrice(km);
        } else if (type == SUBWAY) {
            return subwayPrice(km);
        }
        return 0;
    }
    
    //PriceCalculator 类很明显的问题就是并不是单一职责，首先它承担计算公交车和地铁乘坐价格的职责，
    //另一个问题就是通过if-else的形式来判断使用哪种计算形式。当我们增加一种出行方式时，如出租车，
    //那么我们就需要在PriceCalculator 中增加一个方法来计算出租车出行的价格，并且在calculatePrice(int km, int type)函数增加一个判断
//    private static final int TAXI = 3;
//
//    /***
//     * 每公里2块
//     *
//     * @param km
//     * @return
//     */
//    private int taixPrice(int km) {
//        return km * 2;
//    }
//
//    /**
//     * 根据不同类型计算
//     *
//     * @param km
//     * @param type
//     * @return
//     */
//    int calculatePrice(int km, int type) {
//        if (type == BUS) {
//            return busPrice(km);
//        } else if (type == SUBWAY) {
//            return subwayPrice(km);
//        } else if (type == TAXI) {
//            return taixPrice(km);
//        }
//        return 0;
//    }


}

