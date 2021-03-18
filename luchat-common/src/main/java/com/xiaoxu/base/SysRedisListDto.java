package com.xiaoxu.base;

import lombok.Data;


import java.io.Serializable;
import java.util.List;

/**
 * @author xx
 * @create 2021/3/18 15:52
 */
@Data
public class SysRedisListDto implements Serializable{
    private static final long serialVersionUID = -5371827333869283982L;

    private List<BaseEntity> list;
}
