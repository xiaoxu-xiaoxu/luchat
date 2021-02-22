package com.xiaoxu.base;

import lombok.Data;

import java.util.Map;

/**
 * @author xx
 * @create 2021/2/4 17:22
 */
@Data
public class Page{

    private Integer pageNo;

    private Integer pageSize;

    private Map<String, Object> param;

    public Page(Integer pageNo, Integer pageSize, Map<String, Object> param){
        this.pageNo = pageNo == null ? 1 : pageNo;
        this.pageSize = pageSize == null ? 5 : pageSize;
        this.param = param;
    }

}
