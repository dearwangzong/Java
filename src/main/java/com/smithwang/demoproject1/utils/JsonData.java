package com.smithwang.demoproject1.utils;


import lombok.Data;

@Data
public class JsonData {

    private Integer code;

    private Object data;

    private String msg;

    private String errMsg;


    public  JsonData (){}

    public  JsonData(Integer code,Object data,String msg,String errMsg){
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.errMsg = errMsg;
    }

    public  static  JsonData success(Object value){
        return  new JsonData(200,value,"成功","");
    }

    public  static  JsonData fail(Object value,String errMsg){
        return  new JsonData(200,value,"出现异常",errMsg);
    }
}
