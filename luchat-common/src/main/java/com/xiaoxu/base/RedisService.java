package com.xiaoxu.base;


import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;


/**
 * @author xx
 * @create 2021/2/23 14:43
 */
public class RedisService<K extends Serializable, V extends Serializable>{

    @Resource
    private RedisTemplate<K, V> redisTemplate;

    public void set(K key, V value){
        redisTemplate.opsForValue().set(key, value);
    }

    public V get(K key){
        return redisTemplate.opsForValue().get(key);
    }

    public void expire(K key, V value, Long time){
        redisTemplate.opsForValue().set(key, value, time);
    }

    public void expire(K key, V value, Long time, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    public void delete(K key){
        redisTemplate.delete(key);
    }

    public void change(K key, V value){
        redisTemplate.opsForValue().getAndSet(key, value);
    }

    public void setBean(K key, V t){
        redisTemplate.opsForValue().set(key, t);
    }


    public V getBean(String key){
        return redisTemplate.opsForValue().get(key);
    }


}
