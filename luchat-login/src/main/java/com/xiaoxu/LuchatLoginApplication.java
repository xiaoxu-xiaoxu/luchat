package com.xiaoxu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xx
 * @create 2021/2/4 14:54
 */
@SpringBootApplication
//@MapperScan(basePackages = {"com.xiaoxu.mapper"})
public class LuchatLoginApplication{
    public static void main(String[] args){
        SpringApplication.run(LuchatLoginApplication.class, args);
    }
}
