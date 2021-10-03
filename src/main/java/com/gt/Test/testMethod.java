package com.gt.Test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class testMethod {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test01(){
        System.out.println(jdbcTemplate);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        System.out.println(aLong);
    }

}
