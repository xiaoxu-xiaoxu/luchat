package com.xiaoxu;

import com.xiaoxu.dao.impl.UserDao;
import org.junit.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import sun.security.provider.MD5;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author xx
 * @create 2021/2/5 9:56
 */
public class Test1{

    UserDao userDao = new UserDao();

    @Test
    public void test1(){

    }

    @Test
    public void test() throws Exception{
        Class<? extends UserDao> aClass = userDao.getClass();
        Method selectUserByPage = aClass.getDeclaredMethod("selectUserByPage", Map.class);
        //selectUserByPage.invoke(aClass.newInstance(), new H)
    }
}
