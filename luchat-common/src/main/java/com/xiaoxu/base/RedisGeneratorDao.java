package com.xiaoxu.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author xx
 * @create 2021/3/18 15:50
 */
public abstract class RedisGeneratorDao<K extends Serializable, V extends Serializable>  {

    @Resource
    protected RedisTemplate<K, V> redisTemplate;

    /**
     * 设置redisTemplate
     * @param redisTemplate the redisTemplate to set
     */
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取 RedisSerializer
     * <br>------------------------------<br>
     * @return RedisSerializer
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }
    /**
     * @param tableKey 表key
     * @param dataKey 日期key
     * @param v 。。
     */

    public void insert(K tableKey, String dataKey, V v) {
        redisTemplate.opsForHash().put(tableKey, dataKey, v);
    }
    /**
     * @param tableKey 表key
     * @param dataKey 日期key
     * @param obj 类
     */

    public void insert(K tableKey, String dataKey, Object obj) {
        redisTemplate.opsForHash().put(tableKey, dataKey, obj);
    }
    /**
     * @param tableKey 表key
     * @param dataKey 日期key
     * @param v 。。
     */

    public void update(K tableKey, String dataKey, V v) {
        redisTemplate.opsForHash().put(tableKey, dataKey, v);
    }
    /**
     * @param tableKey 表key
     * @param dataKey	 日期key
     * @param obj 类
     */

    public void update(K tableKey, String dataKey, Object obj) {
        redisTemplate.opsForHash().put(tableKey, dataKey, obj);
    }
    /**
     * @param tableKey 表key
     * @param dataKey	 日期key
     */

    public void delete(K tableKey, String dataKey) {
        redisTemplate.opsForHash().delete(tableKey, dataKey);
    }
    /**
     * @param tableKey 表key
     */

    public void deleteTable(K tableKey) {
        redisTemplate.delete(tableKey);
    }
    /**
     * @param tableKey 表key
     * @param dataKey	 日期key
     * @return V
     */

    @SuppressWarnings("unchecked")
    public V selectOne(K tableKey, String dataKey) {
        return (V) redisTemplate.opsForHash().get(tableKey, dataKey);
    }
    /**
     * @param tableKey 表key
     * @param dataKeys	 日期key
     * @return List
     */

    public List<Object> selectList(K tableKey, Collection<Object> dataKeys) {
        return (List<Object>) redisTemplate.opsForHash().multiGet(tableKey, dataKeys);
    }
    /**
     * @param tableKey 表key
     * @return List
     */

    public List<Object> selectAllList(K tableKey) {
        return (List<Object>) redisTemplate.opsForHash().values(tableKey);
    }
    /**
     * @param key key
     * @param value 值
     * @return V
     */

    public V getSetValue(K key, V value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }
    /**
     * @param key key
     * @param value 值
     */

    public void setValue(K key, V value) {
        redisTemplate.opsForValue().set(key, value);
    }
    /**
     * @param key key
     * @return V
     */

    public V getValue(K key) {
        return redisTemplate.opsForValue().get(key);
    }
    /**
     * @param key key
     * @param value 值
     * @return bool
     */

    public boolean setNx(K key, V value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }
    /**
     * @param key key
     */

    public void delValue(K key) {
        redisTemplate.delete(key);
    }
    /**
     * @param tableKey 表key
     */

    public void clearKey(K tableKey) {
        redisTemplate.delete(tableKey);
    }
}
