package com.example;

/**
 * Created by $lyl on 2017/8/19.
 */


@Description("I am class annotation")
public class Child extends Person{

    @Override
    @Description("I am method annotation")
    public String name() {
        return super.name();
    }
}
