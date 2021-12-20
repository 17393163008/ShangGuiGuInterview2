package com.pqq.test;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 潘勤强
 * @create 2021-12-19 9:56
 *
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该同时进行
 * 但是
 * 如果有一个线程想去写共享资源来，就不应该再有其他线程可以对该资源进行读或写
 *
 * 小总结：
 *  读-读能共存
 *  读-写不能共存
 *  写-写不能共存
 *
 *  写操作：原子+独占,整个过程是一个完整的统一体，中间不允许被分割，被打断
 *
 */

class MyCache   //资源类
{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value)
    {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入：" + key);
            try {
                //暂停300ms线程
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }


    }
    public void get(String key)
    {
        rwLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取：" + key);
            try {
                //暂停300ms线程
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成:" + res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }

//    public void clearMap()
//    {
//        map.clear();
//    }


}

public class ReadWriteLockDemo {
    public static void main(String[] args){
        MyCache myCache = new MyCache();

        for (int i = 1; i <=5 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt+"",tempInt+"");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <=5 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt+"");
            }, String.valueOf(i)).start();
        }

    }
}
