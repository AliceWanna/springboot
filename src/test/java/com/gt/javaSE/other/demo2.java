package com.gt.javaSE.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


interface InterfaceDemo{
    void m1();
    void m2();
}

class demo{
    public InterfaceDemo getInstance (InterfaceDemo interfaceDemo){
        return new InterfaceDemo() {
            @Override
            public void m1() {
            }
            @Override
            public void m2() {
            }
        };
    }
}
class Outer{
    private int aaaa;
    static class Inner{
        private static int i = 10;
        private int a = 0;
        void m(){
            System.out.println(i);
        }
    }

    public void m(){
        int i = Inner.i;
        class p{
            void  mmmm(){
                System.out.println(aaaa);
            }
        }
        p p = new p();
    }

}
@Slf4j
public class demo2 {

    @Test
    public void t2(){
        Outer.Inner i = new Outer.Inner();
        i.m();
    }

    class Base {
        public void method(){}
    }

    interface demo{
        default void method(){}
        static void me(){}
    }

    class Sub extends Base implements demo{
        public void method(){
            super.method();
            demo.super.method();
        };
    }

    @Test
    public void t1(){
        Sub s = new Sub();
    }
}
