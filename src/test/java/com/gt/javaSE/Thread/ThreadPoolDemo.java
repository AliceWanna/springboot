package com.gt.javaSE.Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class thread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + "--------" + i);
        }
    }
}

class thread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + i);
        }
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool =(ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        pool.setCorePoolSize(10);
        pool.setMaximumPoolSize(20);
        pool.execute(new thread1());
        pool.execute(new thread1());
        pool.shutdown();
    }
}
