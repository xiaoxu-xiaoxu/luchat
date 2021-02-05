package com.xiaoxu.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xx
 * @create 2021/1/15 14:18
 */
@Data
public class JsonResp{

    private String Msg;

    private Integer result;

    private Integer code;

    private final HashMap<String, Object> data = new HashMap<>();

    public JsonResp putData(String name, Object data){
        this.data.put(name, data);
        return this;
    }

}
