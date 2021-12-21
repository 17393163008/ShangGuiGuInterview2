package com.pqq.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 潘勤强
 * @create 2021-12-20 19:09
 */
public class SyncAndReetrantLockDemo {
    public static void main(String[] args) {
        synchronized (new Object()){

        }

        new ReentrantLock();
    }
}
