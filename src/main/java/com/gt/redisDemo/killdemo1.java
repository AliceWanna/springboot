package com.gt.redisDemo;

import com.gt.Utils.JedisPoolUtil;
import com.gt.Utils.jedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.List;

public class killdemo1 {
    static String secKillScript ="local userid=KEYS[1];\r\n" +
            "local prodid=KEYS[2];\r\n" +
            "local qtkey='prokill:'..prodid..\":pro\";\r\n" +
            "local usersKey='prokill:'..prodid..\":user\";\r\n" +
            "local userExists=redis.call(\"sismember\",usersKey,userid);\r\n" +
            "if tonumber(userExists)==1 then \r\n" +
            "   return 2;\r\n" +
            "end\r\n" +
            "local num= redis.call(\"get\" ,qtkey);\r\n" +
            "if tonumber(num)<=0 then \r\n" +
            "   return 0;\r\n" +
            "else \r\n" +
            "   redis.call(\"decr\",qtkey);\r\n" +
            "   redis.call(\"sadd\",usersKey,userid);\r\n" +
            "end\r\n" +
            "return 1" ;

    public static boolean doSecKill(String uid,String prodid) throws IOException {

        JedisPool jedispool =  JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis=jedispool.getResource();

        //String sha1=  .secKillScript;
        String sha1=  jedis.scriptLoad(secKillScript);
        Object result= jedis.evalsha(sha1, 2, uid,prodid);

        String reString=String.valueOf(result);
        if ("0".equals( reString )  ) {
            System.err.println("已抢空！！");
        }else if("1".equals( reString )  )  {
            System.out.println("抢购成功！！！！");
        }else if("2".equals( reString )  )  {
            System.err.println("该用户已抢过！！");
        }else{
            System.err.println("抢购异常！！");
        }
        jedis.close();
        return true;
    }

    public static boolean doKill_v2(String uid,String pid){
        if(uid == null | pid == null){
            return false;
        }
        Jedis jedis = jedisUtils.getJedis();
        String kcKey = "prokill:" + pid + ":pro";
        String userKey = "prokill:" + pid + ":user";

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

    public static boolean doKill_v1(String uid,String pid){
        if(uid == null | pid == null){
            return false;
        }
        Jedis jedis = jedisUtils.getJedis();
        String kcKey = "prokill:" + pid + ":pro";
        String userKey = "prokill:" + pid + ":user";

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

        jedis.decr(kcKey);
        jedis.sadd(userKey,uid);

        System.out.println("秒杀成功!");
        jedis.close();
        return true;
    }


}
