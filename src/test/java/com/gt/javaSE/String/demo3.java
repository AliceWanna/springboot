package com.gt.javaSE.String;

import org.junit.jupiter.api.Test;

public class demo3 {

    @Test
    public void test1(){
        String a = new String();
        String b = new String("");
        String c = "";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a.length());
        System.out.println(b.length());
        System.out.println(c.length());
    }
}
