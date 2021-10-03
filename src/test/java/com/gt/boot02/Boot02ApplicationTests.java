package com.gt.boot02;

import com.gt.Mapper.userMapper;
import com.gt.bean.User;
import com.gt.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class Boot02ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    userService userService;

    @Autowired
    userMapper userMapper;

    @Test
    void test02(){
        List<User> users = userMapper.selectItems(4, 4);
        users.forEach(System.out::println);
    }


    @Test
    void test01(){
//        userMapper.insert(new User("lisi",12,"87@email"));
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
        int pageTotalCount = userMapper.selectCount(null).intValue();
        System.out.println(pageTotalCount);
    }

    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
//        log.info("jdbc:{}",jdbcTemplate);
//        System.out.println("lll");
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
//        log.info("记录总数：{}",aLong);

    }

}
