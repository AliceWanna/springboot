package com.gt.javaSE.other;

import com.javaSE.bean.ThreadTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class demo3 {

    @Test
    public void test1(){
        ThreadTest t = new ThreadTest();
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("------------main--------------");
        }
    }
}
