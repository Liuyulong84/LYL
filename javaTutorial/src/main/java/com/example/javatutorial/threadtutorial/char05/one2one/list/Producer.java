package com.example.javatutorial.threadtutorial.char05.one2one.list;

/**
 * Created by byhieg on 17/2/1.
 * Mail to byhieg@gmail.com
 */
public class Producer implements Runnable{

    private MyQueue queue;

    public Producer(MyQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for (;;) {
            queue.push(System.currentTimeMillis());
        }
    }
}
