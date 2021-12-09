package com.javaSE.bean;

import com.gt.bean.demo1;
import org.junit.Test;

public class ReloadDemo {

    public void test(String... args) {
        for (String arg : args)
            System.out.println(arg);
    }

    @Test
    public void test() {
        demo1 d = new demo1();
        demo1 d2 = new demo1();
    }
}