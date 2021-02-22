package com.xiaoxu.controller;

import com.xiaoxu.base.JsonResp;
import com.xiaoxu.bean.User;
import com.xiaoxu.constants.APIConstants;
import com.xiaoxu.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author xx
 * @create 2021/2/22 14:59
 */
@Controller
@RequestMapping("register")
public class RegisterController{

    @Resource
    private IUserService userService;

    @RequestMapping("register")
    @ResponseBody
    public JsonResp register(User user){
        JsonResp resp = new JsonResp();
        if(StringUtils.isAnyEmpty(user.getName(), user.getPassword(), user.getPhone(), user.getEmail())){
            resp.setResult(APIConstants.RESULT_ERROR);
            resp.setMsg("参数不能为空");
            return resp;
        }
        return userService.register(user);
    }

}
