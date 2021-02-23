package com.xiaoxu.controller;

import com.xiaoxu.base.BaseController;
import com.xiaoxu.base.JsonResp;
import com.xiaoxu.base.RedisService;
import com.xiaoxu.bean.User;
import com.xiaoxu.constants.APIConstants;
import com.xiaoxu.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xx
 * @create 2021/2/22 14:59
 */
@RestController
@RequestMapping("register")
public class RegisterController extends BaseController{

    @Resource
    private IUserService userService;

    @Resource
    private RedisService redisService;


    @RequestMapping("register")
    public JsonResp register(User user, String authCode){
        JsonResp resp = new JsonResp();
        if(StringUtils.isAnyEmpty(user.getName(), user.getPassword(), user.getPhone(), user.getEmail(), authCode)){
            resp.setResult(APIConstants.RESULT_ERROR);
            resp.setMsg("参数不能为空");
            return resp;
        }
        String str = redisService.get(user.getPhone());
        logger.info("获取到的验证码为：{}", str);
        if(!StringUtils.equals(str, authCode)){
            resp.setResult(APIConstants.RESULT_ERROR);
            resp.setMsg("验证码错误，或者已过期");
            return resp;
        }
        return userService.register(user);
    }

    @RequestMapping("authCode")
    public JsonResp getAuthCode(String phone){
        JsonResp resp = new JsonResp();
        if(StringUtils.isAnyEmpty(phone)){
            resp.setResult(APIConstants.RESULT_ERROR);
            resp.setMsg("手机号不能为空");
            return resp;
        }
        String authCode = userService.getAuthCode(phone);
        resp.setMsg("获取验证码成功");
        resp.setResult(APIConstants.RESULT_SUCCESS);
        resp.putData("authCode", authCode);
        return resp;
    }

}
