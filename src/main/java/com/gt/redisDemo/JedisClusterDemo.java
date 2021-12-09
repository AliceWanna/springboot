package com.gt.redisDemo;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Component
public class JedisClusterDemo {



    public static void main(String[] args) {
        /*
        Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout,
      int maxAttempts, String password, final GenericObjectPoolConfig<Jedis> poolConfig
         */
        Set<HostAndPort> set =new HashSet<HostAndPort>();
        set.add(new HostAndPort("192.168.88.88",6379));
        JedisCluster cluster = new JedisCluster(set,10000, 10000, 100,"alicewanna",new GenericObjectPoolConfig<Jedis>());
        cluster.set("hello","hello");
        System.out.println(cluster.get("hello"));
        cluster.del("hello");
        Boolean hello = cluster.exists("hello");
        if(hello)
            System.out.println("exist");
        else
            System.out.println("not exist");
    }
}
