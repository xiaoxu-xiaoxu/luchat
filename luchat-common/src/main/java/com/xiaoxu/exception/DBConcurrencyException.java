package com.xiaoxu.exception;

/**
 * @author xx
 * @create 2021/2/5 9:24
 */
public class DBConcurrencyException extends RuntimeException{


    public DBConcurrencyException(){
    }

    public DBConcurrencyException(String message){
        super(message);
    }
}
