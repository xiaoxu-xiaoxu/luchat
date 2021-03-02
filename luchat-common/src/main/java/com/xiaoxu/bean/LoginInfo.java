package com.xiaoxu.bean;

import com.xiaoxu.base.BaseEntity;
import lombok.Data;

/**
 * @author xx
 * @create 2021/3/2 11:22
 */
@Data
public class LoginInfo extends BaseEntity{

    private String token;

    private String password;

    private String username;

    private Integer specialFlg;
}
