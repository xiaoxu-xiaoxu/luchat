package com.xiaoxu.service;

import com.github.pagehelper.PageInfo;
import com.xiaoxu.base.JsonResp;
import com.xiaoxu.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xx
 * @create 2021/2/4 15:50
 */
public interface IUserService{


    PageInfo<User> selectUserByPage(Integer pageNo, Integer pageSize, Map<String, Object> param);

    JsonResp register(User user);
}
