package com.xiaoxu;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xx
 * @create 2021/2/4 14:42
 */
public class Test{

    @org.junit.Test
    public void test(){

        boolean equals = StringUtils.equals("1", "2");
        System.out.println(equals);
    }
}
