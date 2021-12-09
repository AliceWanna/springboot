package com.gt.javaSE.Thread;


import org.junit.jupiter.api.Test;

class Window1 implements Runnable{

    private int count = 100;

    @Override
    public void run() {
        while (true){
            synchronized(this){
                if (count > 0) {
                    System.out.println("线程" + Thread.currentThread().getName() + "抢到了票号" + count--);
                } else {
                    break;
                }
            }
        }
    }
}

class Window2 extends Thread{
    private static int count = 100;

    public Window2(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true){
            synchronized(Window2.class){
                if (count > 0) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "抢到了票号" + count--);
                } else {
                    break;
                }
            }
        }
    }
}

public class Windows {

    @Test
    public void t3() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    if(i % 20 == 0)
                        Thread.yield();
                    System.out.println("---------------"+i);
                }
            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        };
        thread.start();
        thread1.start();
    }


        @Test
    public void t2() {
        Window2 window1 = new Window2("线程1");
        Window2 window2 = new Window2("线程2");
        Window2 window3 = new Window2("线程3");

        window1.start();
        window2.start();
        window3.start();

        try {
            window1.join();
            window2.join();
            window3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void t1(){
        Window1 window1 = new Window1();
        Thread thread1 = new Thread(window1,"线程1");
        Thread thread2 = new Thread(window1,"线程2");
        Thread thread3 = new Thread(window1,"线程3");

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
