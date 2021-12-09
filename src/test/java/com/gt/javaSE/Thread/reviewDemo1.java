package com.gt.javaSE.Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

class method1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----:" + i);
        }
    }
}
class method2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "------:" + i);
        }
    }
}

class method3 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum =0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---------:" + i);
            sum+=i;
        }
        return sum;
    }
}

class buy implements Runnable{
    private static int t = 1000;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(t>0){
                    System.out.println(Thread.currentThread().getName() + "---->" + t--);
                }
                else{
                    break;
                }
            }
        }
    }
}

public class reviewDemo1 {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        buy buy = new buy();
        Thread thread1 = new Thread(buy);
        Thread thread2 = new Thread(buy);
        Thread thread3 = new Thread(buy);
        Thread thread4 = new Thread(buy);
        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.execute(thread4);
//        pool.execute(new buy());
//        pool.execute(new buy());
//        pool.execute(new buy());

        pool.shutdown();

//        method3 method3 = new method3();
//        FutureTask<Integer> f = new FutureTask<>(method3);
//        ExecutorService e = Executors.newFixedThreadPool(10);
//        System.out.println(e.getClass());
    }

    @Test
    public void test4() throws Exception{
        method3 method3 = new method3();
        FutureTask<Integer> f = new FutureTask<>(method3);
        ThreadPoolExecutor e = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        Future<Integer> submit = e.submit(method3);
        Integer integer = submit.get();
        System.out.println(integer);
    }

        @Test
    public void test3() {
        method3 method3 = new method3();
        FutureTask<Integer> f = new FutureTask<>(method3);
        Thread t1 = new Thread(f,"线程一");
        Thread t2 = new Thread(f,"线程er");
        Thread t3 = new Thread(f,"线程san");
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println("main---->" + i);
        }
    }


    @Test
    public void test2() {
        method2 m1 = new method2();
        method2 m2 = new method2();
        method2 m3 = new method2();
        m1.start();
        m2.start();
        m3.start();
    }

        @Test
    public void test1(){
        method1 m = new method1();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        Thread t3 = new Thread(m);
        t1.start();
        t2.start();
        t3.start();
        Thread.yield();
        System.out.println(t1.getName()+t1.getState());
        System.out.println(t2.getName()+t2.getState());
        System.out.println(t3.getName()+t3.getState());
    }
}
