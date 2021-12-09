package com.gt.javaSE.dataAPI;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class demo1 {

    @Test
    public void demo() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String data = "2021-03-04";
        java.util.Date parse = sdf.parse(data);
        java.sql.Date sqlDate = new java.sql.Date(parse.getTime());
        java.util.Date utilDate = new Date(sqlDate.getTime());
    }

        @Test
    public void test2() {
        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());
        System.out.println(new Date().getTime());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

        @Test
    public void test1(){
        long l = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ---> hh:mm:ss");
        String s = sdf.format(new Date().getTime()+9116511L);
        System.out.println(s);
    }
}
