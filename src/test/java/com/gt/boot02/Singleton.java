package com.gt.boot02;

public class Singleton {

    private static Singleton singleton;

    private Singleton(){}

    private static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null) {
                    singleton = new Singleton();
                }
                return singleton;
            }
        }else {
            return singleton;
        }
    }
}

