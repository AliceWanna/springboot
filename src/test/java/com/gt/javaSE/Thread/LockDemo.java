package com.gt.javaSE.Thread;


import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

class LockTest extends Thread{

    private static int count = 1000;
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            try{
                if (count > 0) {
                    System.out.println("线程" + Thread.currentThread().getName() + "抢到了票号" + count--);
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
public class LockDemo {
    @Test
    public void t1(){
        LockTest Thread1 = new LockTest();
        LockTest Thread2 = new LockTest();
        LockTest Thread3 = new LockTest();
        Thread3.start();
        Thread1.start();
        Thread2.start();

    }
}
