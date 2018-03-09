package com.example.javatutorial.threadtutorial.char02;

/**
 * Created by byhieg on 17/1/3.
 * Mail to byhieg@gmail.com
 */
public class DoubleSynThreadB extends Thread{

    private ObjectService objectService;

    public DoubleSynThreadB(ObjectService objectService){
        this.objectService = objectService;

    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodB();
    }
}
