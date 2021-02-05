package com.xiaoxu.service.impl;

import com.github.pagehelper.PageInfo;
import com.xiaoxu.base.BaseService;
import com.xiaoxu.base.Page;
import com.xiaoxu.bean.User;
import com.xiaoxu.dao.IUserDao;
import com.xiaoxu.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author xx
 * @create 2021/2/4 15:50
 */
@Service
@Transactional
public class UserService extends BaseService implements IUserService{

    @Resource
    private IUserDao userDao;


    @Override
    public PageInfo<User> selectUserByPage(Integer pageNo, Integer pageSize, Map<String, Object> param){
        Page<User> p = new Page<>(pageNo, pageSize, param);
        return userDao.selectUserByPage(p);
    }
}
