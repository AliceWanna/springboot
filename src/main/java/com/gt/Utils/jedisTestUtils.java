package com.gt.Utils;


import redis.clients.jedis.Jedis;

public class jedisTestUtils {

    private static Jedis jedis;
    static {
        jedis = new Jedis("192.168.88.88",6379);
        jedis.auth("alicewanna");
    }
    public static Jedis getJedis(){
        return jedis;
    }

    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
}
