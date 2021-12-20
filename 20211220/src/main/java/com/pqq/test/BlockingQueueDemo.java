package com.pqq.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 潘勤强
 * @create 2021-12-20 16:30
 *
 * 1
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
//        List lsit = null;
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                synchronousQueue.put("1");

                System.out.println(Thread.currentThread().getName()+"\t put 2");
                synchronousQueue.put("2");

                System.out.println(Thread.currentThread().getName()+"\t put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }, "AAA").start();

        new Thread(() -> {
            try {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }, "BBB").start();
    }
}
