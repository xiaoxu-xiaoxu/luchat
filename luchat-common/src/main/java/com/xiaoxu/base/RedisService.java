package com.xiaoxu.base;


import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @author xx
 * @create 2021/2/23 14:43
 */
public class RedisService{

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void expire(String key, String value, Long time){
        redisTemplate.opsForValue().set(key, value, time);
    }

    public void expire(String key, String value, Long time, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }

    public void change(String key, String value){
        redisTemplate.opsForValue().getAndSet(key, value);
    }


}