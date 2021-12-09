package com.gt.boot02;

import com.gt.bean.Pet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Slf4j
@SpringBootTest
public class redisDemo {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test3() {
        String s1 =new  String("abc");
        String s2 =new String("abc");
        if(s1==s2)
            System.out.println("==true");
        else
            System.out.println("==false");
        if(s1.equals(s2))
            System.out.println("equalstrue");
        else
            System.out.println("equalsfalse");
    }


        @Test
    public void test2() {
        Pet p = new Pet("k",1);
        redisTemplate.opsForValue().set("p",p);
        System.out.println(redisTemplate.opsForValue().get("p"));
    }

        @Test
    public void test1(){
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushAll();
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();

        ops.set("k2","v1");
        Object k1 = ops.get("k2");
        System.out.println(k1);
    }
}
