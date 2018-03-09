package com.example.javatutorial.threadtutorial.char02;

/**
 * Created by byhieg on 17/1/3.
 * Mail to byhieg@gmail.com
 */
public class SynBlockThreadA extends Thread{

    private SynBlockService service;

    public SynBlockThreadA(SynBlockService service){
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.setUSernamePassword("a","aa");
    }
}
