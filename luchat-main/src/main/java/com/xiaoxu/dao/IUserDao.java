package com.xiaoxu.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxu.base.Page;
import com.xiaoxu.bean.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

public interface IUserDao{

    PageInfo<User> selectUserByPage(Page page);

    void insertSelective(User user);

    Integer selectUserByPhone(User user);
}