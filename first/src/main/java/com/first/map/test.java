package com.first.map;

/**
 * Created by $lyl on 2018/3/29.
 */

public class test {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        MAP map = linkedHashMap;
        map.get();
        HashMap hashMap = linkedHashMap;
        hashMap.get();
        ((MAP)linkedHashMap).get();
        ((HashMap)linkedHashMap).get();
    }
}
