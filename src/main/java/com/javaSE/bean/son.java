package com.javaSE.bean;

public class son extends father{

    private String name;
    private Integer in;
    private Double dodo;

    public void say() {
        System.out.println("son say something");
    }

    @Override
    public void talk() {
        System.out.println("son talk");
    }

    public son(){
        System.out.println("子类无参构造");
    }

    public son(String name){
        System.out.println("子类有参构造");
        System.out.println(name);
    }
}
