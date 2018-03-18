package com.example;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by $lyl on 2017/10/11.
 */

public class MyClass {

    public static void main(String[] args) {
        final int N = 4;
        final CyclicBarrier barrier = new CyclicBarrier(N);
        final StringBuilder[] buffers = new StringBuilder[N];
        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; i++) {
            buffers[i] = new StringBuilder();
            final int id = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int x = id; ; x = (x + N - 1) % N) {
                            barrier.await();
                            System.out.println(Thread.currentThread().getName()+ " write" + (id +1) + "to " + x );
                            buffers[x].append(id + 1);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
        ////////////////////////////////////////////////////////
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*for (StringBuilder buffer : buffers) {
            System.out.println(buffer);
        }*/
        System.exit(0);
    }
}
