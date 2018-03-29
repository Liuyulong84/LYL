package com.first.map;

/**
 * Created by $lyl on 2018/3/29.
 */

public class LinkedHashMap extends HashMap implements MAP {
    @Override
    public int get() {
        System.out.println("LinkedHashMap get");
        return 0;
    }

    @Override
    public void put() {
        System.out.println("LinkedHashMap put");
        super.put();
    }
}
