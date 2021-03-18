package com.xiaoxu.base;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xx
 * @create 2021/3/18 15:53
 */
@Repository
public class CommonRedisDao extends RedisGeneratorDao<String, SysRedisListDto>{

    private String tableKey = "imsRedis";

    private String shopCartKey = "shopCatRedis";

    public List<BaseEntity> selectList(String token){
        SysRedisListDto sysRedisListDto = selectOne(tableKey, token);
        if(sysRedisListDto == null){
            return null;
        }else{
            return sysRedisListDto.getList();
        }

    }

    public void updateList(String token, List<BaseEntity> list){
        SysRedisListDto sysRedisListDto = new SysRedisListDto();
        sysRedisListDto.setList(list);
        update(tableKey, token, sysRedisListDto);
    }

    public void insertList(String token, List<BaseEntity> list){
        SysRedisListDto sysRedisListDto = new SysRedisListDto();
        sysRedisListDto.setList(list);
        insert(tableKey, token, sysRedisListDto);
    }

    public void deleteList(String token){
        delete(tableKey, token);
    }

    public Object selectObj(String token){
        return selectOne(tableKey, token);
    }

    public void insertObj(String token, Object obj) {
        insert(tableKey, token, obj);
    }

    public void updateObj(String token, Object obj){
        update(tableKey, token, obj);
    }

    public void deleteObj(String token){
        delete(tableKey, token);
    }

    public void clearTable(){
        clearKey(tableKey);
    }

    public List<BaseEntity> selectShoppingCartList(String token){
        SysRedisListDto sysRedisListDto = selectOne(shopCartKey, token);
        if(sysRedisListDto == null){
            return null;
        }else{
            return sysRedisListDto.getList();
        }

    }

    public Object selectShoppingObj(String token){
        return selectOne(shopCartKey, token);
    }

    public void insertShoppingCartObj(String token, Object obj) {
        insert(shopCartKey, token, obj);
    }

    public void clearTableShop(){
        clearKey(shopCartKey);
    }
}
