package com.gt.javaSE.ENUM;

import com.javaSE.bean.EnumDemo1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class demo1 {

    @Test
    public void t2(){
        season spring = season.SPRING;
        season[] values = spring.values();
        for (season value : values) {
            System.out.println(value);
        }
        Enum e = spring;
        System.out.println("_________________");
        Class<? extends Enum> aClass = e.getClass();
        season[] enumConstants = (season[]) aClass.getEnumConstants();
        for (season enumConstant : enumConstants) {
            System.out.println(Arrays.toString(enumConstants));
        }
    }

    @Test
    public void t1(){
        EnumDemo1 aBreak = EnumDemo1.BREAK;
        System.out.println(aBreak);
    }
}

enum season implements seasonIner{
    SPRING,
    SUMMER,
    FAULT,
    WINTER;

    @Override
    public void show() {

    }

    @Override
    public void gogo() {

    }
}

interface seasonIner{
    void show();
    void gogo();
    default void doo(){
        System.out.println("ss");
    }
}