package com.xiaoxu.controller;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import com.xiaoxu.base.BaseController;
import com.xiaoxu.base.JsonResp;
import com.xiaoxu.base.RedisService;
import com.xiaoxu.bean.LoginInfo;
import com.xiaoxu.bean.User;
import com.xiaoxu.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xx
 * @create 2021/2/4 15:51
 */
@RestController
@RequestMapping("login")
public class LoginController extends BaseController{

    @Resource
    private IUserService userService;

    @Resource
    private RedisService redisService;

    @RequestMapping("login")
    public JsonResp login(HttpServletRequest request, HttpServletResponse response){
        JsonResp resp = new JsonResp();
        //request.getSession().setAttribute("token", "xiaoxu");
        String uuid = IdUtil.randomUUID();
        Cookie cookie = new Cookie("login", uuid);
        cookie.setMaxAge(1220);
        cookie.setPath("/");
        redisService.expire(uuid, new LoginInfo(), 15L, TimeUnit.SECONDS);
        response.addCookie(cookie);
        return resp;
    }

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
