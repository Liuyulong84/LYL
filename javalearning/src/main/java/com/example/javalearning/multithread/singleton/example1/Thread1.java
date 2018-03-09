package com.example.javalearning.multithread.singleton.example1;

/**
 * Created by Brian on 2016/4/16.
 */
public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject1.getInstance().hashCode() + " " + MyObject1.getInstance());
    }
}
