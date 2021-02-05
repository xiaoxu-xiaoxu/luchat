package com.xiaoxu.bean;

import com.xiaoxu.base.BaseEntity;
import lombok.Data;

/**
 * @author xx
 * @create 2021/2/4 14:24
 */
@Data
public class User extends BaseEntity{

    private Integer id;

    private String name;

    private String password;

    private String phone;

    private String email;

    private String specialFlg;
}
