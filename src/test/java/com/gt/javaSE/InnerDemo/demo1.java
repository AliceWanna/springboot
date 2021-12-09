package com.gt.javaSE.InnerDemo;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.*;

class out{
    int a = 10;
    public static class innner{
        void show(){
//            System.out.println(a);
        }
    }
}

public class demo1 {

    @Test
    public void t2() {
//        out out = new out();
//        com.gt.javaSE.InnerDemo.out.innner innner = out.new innner();
//        out.a = 20;
//        innner.show();
    }

        @Test
    public void t1(){
        List<Object> list = Arrays.asList(123, "hello", Month.MAY, new Date());
        ArrayList<Object> hello = new ArrayList<>(list);
        Iterator<Object> iterator1 = hello.iterator();
        Iterator<Object> iterator2 = hello.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            if("hello".equals(next))
                iterator1.remove();
        }
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        Iterator<Object> iterator3 = hello.iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }

    }
}
