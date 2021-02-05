package com.xiaoxu.base;

import lombok.Data;

import java.util.Date;

/**
 * @author xx
 * @create 2021/2/4 14:36
 */
@Data
public class BaseEntity{

    private static final long serialVersionUID = 1L;

    private Integer versionNo;

    private Integer delFlg;

    private String description;

    private String extendField1;

    private String extendField2;

    private String extendField3;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifyTime;
}
