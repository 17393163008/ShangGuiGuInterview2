package com.pqq.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author 潘勤强
 * @create 2021-12-20 22:55
 */

class MyThread implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {
        System.out.println("*******come in Callable");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask, "AA").start();
        new Thread(futureTask, "BB").start();

        System.out.println(Thread.currentThread().getName()+"\t *******************");

        int result01 = 100;
        int result02 = futureTask.get();

        System.out.println("*****result:" + (result01+result02));

    }
}
