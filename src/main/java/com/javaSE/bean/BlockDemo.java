package com.javaSE.bean;

public class BlockDemo {


   static{
       System.out.println("静态代码块");
   }

    {
        System.out.println("非静态代码块");
    }
    public BlockDemo(){
        System.out.println("构造器");
    }
}
