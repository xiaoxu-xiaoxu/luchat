package com.xiaoxu.interceptor;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.xiaoxu.base.RedisService;
import com.xiaoxu.bean.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xx
 * @create 2021/3/2 11:24
 */
@Component
public class CommonInterceptor implements HandlerInterceptor{

    @Resource
    private RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        logger.info("-------------------commonInterceptor-------------------");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if(StrUtil.isEmpty(token)){
            Cookie[] cookies = request.getCookies();
            String loginInfo = null;
            if(cookies != null && cookies.length != 0){
                for(Cookie cookie : cookies){
                    if(StrUtil.equals(cookie.getName(), "login")){
                        loginInfo = cookie.getValue();
                        break;
                    }
                }
            }

            if(StrUtil.isEmpty(loginInfo)){
                response.sendRedirect("http://localhost:7070/login/index");
                return false;
            }else{
                LoginInfo login = (LoginInfo) redisService.getBean(loginInfo);
                if(login == null){
                    response.sendRedirect("http://localhost:7070/login/index");
                    return false;
                }
                logger.info("根据cookie登录");
                String uuid = IdUtil.randomUUID();
                session.setAttribute("token", uuid);
            }
        }
        logger.info("用户token为：{}", token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{


    }
}
