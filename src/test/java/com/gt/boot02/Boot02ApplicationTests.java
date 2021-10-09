package com.gt.boot02;

import com.gt.Mapper.userMapper;
import com.gt.bean.Pet;
import com.gt.bean.User;
import com.gt.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class Boot02ApplicationTests {

    @Autowired
    ApplicationContext context;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    userService userService;

    @Autowired
    userMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void test05() {
    }

    @Test
    void test04() {
        Assertions.assertNotNull(context,"不为空");
    }


    @Test
    void test03() {

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String a : beanDefinitionNames){
            System.out.println(a);
        }
        Pet pet1 = context.getBean("pet1", Pet.class);
        Assertions.assertNotNull(pet1,"不为空");
        System.out.println(pet1);
    }



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
