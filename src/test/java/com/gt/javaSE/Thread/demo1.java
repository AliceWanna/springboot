package com.gt.javaSE.Thread;

import com.javaSE.Thread.ThreadDemo;
import org.junit.jupiter.api.Test;

class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                System.out.println(getName() + ": " + i);
        }
    }
}


class ThreadDemo2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class demo1 {

    @Test
    public void t3() {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.setName("继承方式");

        Thread threadDemo2 = new Thread(new ThreadDemo2());
        threadDemo2.setName("实现方式");

        threadDemo1.setPriority(Thread.MAX_PRIORITY);
        threadDemo2.setPriority(Thread.MIN_PRIORITY);

        threadDemo1.start();
        threadDemo2.start();
        try {
            threadDemo1.join();
            threadDemo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadDemo1.getName() + "------------" + threadDemo1.isAlive());
        System.out.println(threadDemo2.getName() + "------------" + threadDemo2.isAlive());
    }

        @Test
    public void t2(){
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        Thread thread = new Thread(threadDemo2);
        thread.setName("demo2");
        thread.start();
    }


    @Test
    public void t1(){
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }
}
