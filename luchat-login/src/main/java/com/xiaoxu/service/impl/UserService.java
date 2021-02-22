package com.xiaoxu.service.impl;

import com.github.pagehelper.PageInfo;
import com.xiaoxu.base.BaseService;
import com.xiaoxu.base.JsonResp;
import com.xiaoxu.base.Page;
import com.xiaoxu.bean.User;
import com.xiaoxu.constants.APIConstants;
import com.xiaoxu.dao.IUserDao;
import com.xiaoxu.service.IUserService;
import com.xiaoxu.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
        Page p = new Page(pageNo, pageSize, param);
        return userDao.selectUserByPage(p);
    }

    @Override
    public JsonResp register(User user){
        JsonResp resp = new JsonResp();
        Integer count = userDao.selectUserByPhone(user);
        if(count != null){
            resp.setResult(APIConstants.RESULT_SUCCESS);
            resp.setMsg("该手机号已经注册过");
            return resp;
        }
        String password = MD5.getMD5(user.getPassword());
        user.setPassword(password);
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        userDao.insertSelective(user);
        resp.setResult(APIConstants.RESULT_SUCCESS);
        resp.setMsg("注册成功");
        return resp;
    }
}
