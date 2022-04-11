package com.bai.config.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommenResult<T> {
    private String msg;
    private Boolean success;
    private T data;
    private Object object;
    private int code;
    private int size;
    private Long length;

    public CommenResult(String msg, Boolean success, T data) {
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public CommenResult(int code,String msg,Object object,int size,Long length){
        this.msg = msg;
        this.code = code;
        this.object = object;
        this.size = size;
        this.length = length;
    }

    public CommenResult(int code,String msg){
        this.msg = msg;
        this.code = code;
    }

    public static CommenResult success(String msg,Object object,int size){
        return new CommenResult(1,msg,object,size,null);
    }

    public static CommenResult successPage(String msg,Object object,Long length){
        return new CommenResult(1,msg,object,0,length);
    }

    public static CommenResult error(String msg){
        return new CommenResult(-1,msg);
    }
}
