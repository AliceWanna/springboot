package com.gt.javaSE.String;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class demo2 {
    @Test
    public void t6() {
        StringBuffer buffer = new StringBuffer("1234");
        StringBuffer delete = buffer.delete(1, 3);
        System.out.println(delete == buffer);
        System.out.println(buffer);
//        buffer.replace(1,2,"hellow");
//        System.out.println(buffer);


    }
    @Test
    public void t5() {
        byte[] bytes = {-28, -67, -96, -27, -91, -67, 10};
        String s = new String(bytes);
        System.out.println(s);

        System.out.println("****************");

        String s1 = "你好\n";
        System.out.println(s1);
        System.out.println(Arrays.toString(s1.getBytes()));
    }

        @Test
    public void t4(){
        String by = new String(new char[]{'b'});
        System.out.println(by);

        StringBuffer a = new StringBuffer("19");
        String h = null;
        a.append(h);
        a.append("null");
        System.out.println(a);
    }

    @Test
    public void t3() {
        int a = 19;//10011 --> 100110

        int b = a << 1;
        System.out.println(b);
    }

        @Test
    public void t2() {
        String a = "abc";
//        a.value
        byte aa = 123;
        byte b = '1';
        byte[] bytes = a.getBytes();
        System.out.println(Arrays.toString(bytes));
    }

        @Test
    public void t1(){
        int a = '是';
        char b = '是';
        System.out.println(b);
        System.out.println(a);
        String low = "abcdefAA";
        String up = "ABCDEf";
        String s = low.toUpperCase();
        System.out.println(s);
        s.trim();
        s.compareTo("");
        s.endsWith("");
    }
}
