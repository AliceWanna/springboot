package com.javaSE.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class father {
    private String name;
    private int age;

    public void say(String message){
        System.out.println("father say:" + message);
    }

    public void talk(){
        System.out.println("father walk");
    }

    public father(){
        System.out.println("父类无参构造");
    }
    public father(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public father(int age) {
        this.age = age;
    }

    public father(String name) {
        this.name = name;
    }
}
