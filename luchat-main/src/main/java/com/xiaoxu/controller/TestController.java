package com.xiaoxu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xx
 * @create 2021/3/2 14:06
 */
@RestController
@RequestMapping("test")
public class TestController{

    @RequestMapping("test")
    public String test(){
        return "test";
    }
}
