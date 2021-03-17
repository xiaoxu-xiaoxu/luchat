package com.xiaoxu.config;

import com.xiaoxu.base.RedisService;
import com.xiaoxu.filter.LogFilter;
import com.xiaoxu.interceptor.CommonInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xx
 * @create 2021/2/4 16:00
 */
@Configuration
public class ApplicationConfig implements WebMvcConfigurer{


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration registration = registry.addInterceptor(new CommonInterceptor());
        registration.addPathPatterns("/**", "/*")
                .excludePathPatterns("/login/*", "/register/*", "/favicon.ico", "/error");
    }

    @Bean
    public FilterRegistrationBean<LogFilter> filterRegistrationBean(){
        FilterRegistrationBean<LogFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new LogFilter());
        filter.setName("logFilter");
        filter.setOrder(1);
        filter.addUrlPatterns("/*");
        return filter;
    }

    @Bean
    public RedisService getRedisUtils(){
        return new RedisService();
    }
}
