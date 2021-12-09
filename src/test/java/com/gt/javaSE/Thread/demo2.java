package com.gt.javaSE.Thread;


import org.junit.jupiter.api.Test;

class ThreadDemo11 implements Runnable{

    private final Object obj = new Object();

    @Override
    public void run() {
        synchronized(obj) {
            for (int i = 0; i < 100; i++) {
                System.out.println("*************" + this.getClass());
                this.notify();
                System.out.println(Thread.currentThread().getName() + "---------" + i);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class demo2 {
    @Test
    public void t1 (){
        ThreadDemo11 threadDemo11 = new ThreadDemo11();
        Thread t1= new Thread(threadDemo11);
        Thread t2= new Thread(threadDemo11);
        t1.start();
        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
