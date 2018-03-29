package com.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lyl on 2018/3/18.
 */


public class CircleBubbleTest {

    private static int SIZE = 5;
    private static CyclicBarrier cb;

    public static void main(String[] args) {

        cb = new CyclicBarrier(SIZE, new Runnable() {
            public void run() {
                System.out.println("CyclicBarrier's parties is: " + cb.getParties());
            }
        });

        // 新建5个任务
        for (int i = 0; i < SIZE; i++)
            new InnerThread().start();
    }

    static class InnerThread extends Thread {
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
                for (int i = 0; i < 5; i++) {
                    // 将cb的参与者数量加1
                    // 这样是不行的 哈哈 ，必须是5个不同的线程呀
                    cb.await();
                    System.out.println(Thread.currentThread().getName() + "add " + i + "");
                }
                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
