package com.gt.javaSE.Thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.创建一个实现Callable的实现类
class calldemo1 implements Callable {

    @Override
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"----------"+i);
            sum+=i;
        }
        return sum;
    }
}
public class CallableDemo1 {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        calldemo1 calldemo1 = new calldemo1();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(calldemo1);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
