package com.xiaoxu.controller;

import com.github.pagehelper.PageInfo;
import com.xiaoxu.base.BaseController;
import com.xiaoxu.base.JsonResp;
import com.xiaoxu.bean.User;
import com.xiaoxu.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xx
 * @create 2021/2/4 15:51
 */
@RestController
@RequestMapping("login")
public class LoginController extends BaseController{

    @Resource
    private IUserService userService;

    @RequestMapping("selectUserByPage")
    public JsonResp selectUserByPage(Integer pageSize, Integer pageNo, User user){
        JsonResp resp = new JsonResp();
        Map<String, Object> param = new HashMap<>();
        param.put("name", "xiaoxu");
        PageInfo<User> list = userService.selectUserByPage(pageNo, pageSize, param);
        resp.putData("page", list);
        return resp;
    }


}
