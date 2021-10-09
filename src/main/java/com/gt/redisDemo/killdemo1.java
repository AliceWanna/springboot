package com.gt.redisDemo;

import com.gt.Utils.jedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class killdemo1 {

    public static boolean doKill(String uid,String pid){
        if(uid == null | pid == null){
            return false;
        }
        Jedis jedis = jedisUtils.getJedis();
        String kcKey = "prokill:" + pid + ":pro";
        String userKey = "prokill:" + uid + ":user";

        jedis.watch(kcKey);

        String kcNum = jedis.get(kcKey);
        if(kcNum == null){
            System.out.println("库存未开始!");
            jedis.close();
            return false;
        }
        if(jedis.sismember(userKey,uid)){
            System.out.println("已经秒杀过!");
            jedis.close();
            return false;
        }

        if(Integer.parseInt(jedis.get(kcKey)) <= 0){
            System.out.println("秒杀已结束!");
            jedis.close();
            return false;
        }

        Transaction multi = jedis.multi();
        multi.decr(kcKey);
        multi.sadd(userKey,uid);

        List<Object> exec = multi.exec();

        if(exec == null || exec.size()==0) {
            System.out.println("秒杀失败了....");
            jedis.close();
            return false;
        }

        System.out.println("秒杀成功!");
        jedis.close();
        return true;
    }
}
