package com.xiaoxu.config;

import com.xiaoxu.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author xx
 * @create 2021/2/4 16:00
 */
@Configuration
public class ApplicationConfig{

    @Resource
    private LogFilter logFilter;

    @Bean
    public FilterRegistrationBean<LogFilter> filterRegistrationBean(){
        FilterRegistrationBean<LogFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(logFilter);
        filter.setName("logFilter");
        filter.setOrder(1);
        filter.addUrlPatterns("/*");
        return filter;
    }
}
