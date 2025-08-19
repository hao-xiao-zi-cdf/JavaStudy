package com.hao_xiao_zi.bean.common;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-19
 * Time: 14:57
 */
@Data
public class R {

    int code;
    String message;
    Object data;

    public static R ok(Object data){
        R r = new R();
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static R error(int code,String message){
        R r = new R();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static R error(String message){
        R r = new R();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }

    public static R error(){
        return error(500,"服务器异常");
    }

    public static R ok(){
        return R.ok(null);
    }
}
