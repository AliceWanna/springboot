package com.gt.boot02;

import com.gt.Utils.jedisTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

@Slf4j
public class demo1 {
    @Test
    public void test2(){
        Jedis jedis = new Jedis("192.168.88.88",6379);
        jedis.auth("alicewanna");
        System.out.println(jedis);
    }
    @Test
    public void test1(){
        Jedis jedis1 = jedisTestUtils.getJedis();
        System.out.println(jedis1);
        Jedis jedis2 = jedisTestUtils.getJedis();
        System.out.println(jedis2);
        Jedis jedis = new Jedis("192.168.88.88",6379);
        jedis.auth("alicewanna");
        System.out.println(jedis);
        Assertions.assertEquals(jedis,jedis2,"不同");
    }

}
