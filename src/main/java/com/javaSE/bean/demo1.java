package com.javaSE.bean;

public class demo1 {



    public demo1(){
        System.out.println("构造函数");
    }
    {
        System.out.println("构造代码块");
    }


    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        son s = new son();
        s.say("hello");
    }

}
