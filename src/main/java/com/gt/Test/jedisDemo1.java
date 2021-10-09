package com.gt.Test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class jedisDemo1 {

    private static final String HOST_IP = "192.168.88.88";
    private static final String AUTH = "alicewanna";


    public static void main(String[] args) {

        Jedis jedis = new Jedis(HOST_IP,6379);
        jedis.auth(AUTH);
        String ping = jedis.ping();
        System.out.println(ping);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
