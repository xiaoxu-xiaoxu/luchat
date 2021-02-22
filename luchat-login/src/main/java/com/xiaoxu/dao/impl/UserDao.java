package com.xiaoxu.dao.impl;

import com.github.pagehelper.PageInfo;
import com.xiaoxu.base.BaseDao;
import com.xiaoxu.base.Page;
import com.xiaoxu.bean.User;
import com.xiaoxu.dao.IUserDao;
import org.springframework.stereotype.Component;

/**
 * @author xx
 * @create 2021/2/5 9:31
 */
@Component
public class UserDao extends BaseDao implements IUserDao{

    @Override
    public PageInfo<User> selectUserByPage(Page page){
        return super.selectPage("t_lu_user.selectUserByPage", page);
    }

    @Override
    public void insertSelective(User user){
        super.insert("t_lu_user.insertSelective", user);
    }

    @Override
    public Integer selectUserByPhone(User user){
        return super.selectOne("t_lu_user.selectUserByPhone", user);
    }
}
