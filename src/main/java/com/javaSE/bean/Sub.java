package com.javaSE.bean;

import lombok.Data;

@Data
public class Sub extends Base{

    private int count;

//    public static void t1(){}

    {
        System.out.println("sub非静态代码块");
    }
    static{
        System.out.println("sub静态代码块");
    }

    public Sub(){
        System.out.println("sub constructor");
    }



    public void say() {
        System.out.println("Sub:" + this.count);
        t1();
    }
}
