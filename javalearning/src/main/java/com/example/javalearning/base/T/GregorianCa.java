package com.example.javalearning.base.T;

/**
 * Created by $lyl on 2018/3/13.
 */

public class GregorianCa extends Calendar implements Comparable{

    @Override
    public int compareTo(Object o) {
        System.out.println("second");
        return 0;
    }

    public static void main(String[] args) {
        GregorianCa gregorianCa = new GregorianCa();
        gregorianCa.compareTo(new Object());

        Comparable comparable = new GregorianCa();
        comparable.compareTo(new Object());

        Calendar calendar = new GregorianCa();
        calendar.compareTo(new Object());
    }
}
