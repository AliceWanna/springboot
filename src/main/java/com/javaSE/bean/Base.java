package com.javaSE.bean;

public class Base {

    private int count;


    public static void t1(){}

    {
        System.out.println("Base非静态代码块");
    }
    static{
        System.out.println("Base静态代码块");
    }

    public Base(){
        System.out.println("Base constructor");
    }

    public void common(){
        this.say();
        say();
    }

    public void say(){
        String sa = 1 + "";
        System.out.println("Base:" + this.count);
    }

    public static void main(String[] args) {
        Base base = new Base();
        System.out.println(base.hashCode());
        System.out.println(base);
    }
}
