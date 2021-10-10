package com.gt.Utils;


import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class jedisUtils {

    private static Properties pros;
    static {
        InputStream is = jedisUtils.class.getClassLoader().getResourceAsStream("static/redis/jedis.properties");
        pros = new Properties();
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Jedis getJedis(){
        String ip = pros.getProperty("ip");
        int port = Integer.parseInt(pros.getProperty("port"));
        String auth = pros.getProperty("auth");
        Jedis jedis = new Jedis(ip,port);
        jedis.auth(auth);
        return jedis;
    }

    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
}
