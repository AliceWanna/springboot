package com.gt.javaSE.Gene;


import com.javaSE.bean.Base;
import com.javaSE.bean.Sub;
import org.junit.jupiter.api.Test;


class golang <T>{
    T one;
    T two;
}

public class demo1 {

    @Test
    public void t2() {
        String str1 = "aa";
        byte[] bytes = str1.getBytes();
        golang<String> a = new golang<>();
        golang<Integer> b = new golang<>();
        a.one = "ggg";
        b.one = 123;
        System.out.println(a.getClass()==b.getClass());

    }


    @Test
    public void t1(){
        Object[] obs = new Object[10];
        String[] strs = new String[10];
        System.out.println(obs.getClass());
        obs = strs;
        System.out.println(obs.getClass());

        System.out.println("***************");

        Sub sub = new Sub();
        Base base = new Base();
        System.out.println(base.getClass());
        base = sub;
        base = new Sub();
        System.out.println(base.getClass());
    }
}
