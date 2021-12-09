package com.gt.javaSE.dataAPI;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class timeAPI {

    @Test
    public void t3() throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd---HH:mm:ss");
        String format = dtf.format(LocalDateTime.now());
        System.out.println(format);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor parse = dtf1.parse("1920-02-02");
        System.out.println(parse);
        System.out.println(parse.getClass());
        long aLong = parse.getLong(ChronoField.YEAR);
        System.out.println(aLong);
    }

        @Test
    public void t2() throws Exception {
            LocalDate localDate = LocalDate.ofEpochDay(new Date().getTime());
            System.out.println(localDate);
//        LocalDate now = LocalDate.now();
//        System.out.println(now);
//        LocalDate localDate = now.plusDays(-10);
//        System.out.println(localDate);
    }
        @Test
    public void t1() throws Exception{
        Instant now1 = Instant.now();
        Thread.sleep(100L);
        Instant now2 = Instant.now();
        System.out.println(now1.toEpochMilli());
        System.out.println(now2.toEpochMilli());
    }
}
