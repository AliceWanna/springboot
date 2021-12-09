package com.javaSE.bean;

public class demo22 {

    public static int n;

    static {
        System.out.println("static code");
    }
    public static void m(){
        System.out.println("static method");
    }

    public demo22()  {
        System.out.println("demo22 constructor");
    }
}
