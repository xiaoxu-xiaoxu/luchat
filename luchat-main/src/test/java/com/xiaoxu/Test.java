package com.xiaoxu;

import com.xiaoxu.dao.IUserDao;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author xx
 * @create 2021/2/4 15:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test{

    @Resource
    private IUserDao userDao;

    @org.junit.Test
    public void test(){
        //System.out.println(userDao.selectUserByPage(new HashMap<>()));
    }
}
