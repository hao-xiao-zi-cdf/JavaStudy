package com.hao_xiao_zi.globalexceptionhandlerdemo.pojo;

import com.hao_xiao_zi.globalexceptionhandlerdemo.exception.AppExceptionCodeMsg;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-06-10
 * Time: 21:49
 */
public class Resp<T> {

    //服务端返回的错误码
    private int code = 200;
    //服务端返回的错误信息
    private String msg = "success";
    //我们服务端返回的数据
    private T data;

    //单例模式，不能手动创建Resp对象
    private Resp(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Resp success(T data){
        Resp resp = new Resp(200, "success", data);
        return resp;
    }

    public static <T> Resp success(String msg,T data){
        Resp resp = new Resp(200,msg, data);
        return resp;
    }

    public static <T> Resp error(AppExceptionCodeMsg appExceptionCodeMsg){
        Resp resp = new Resp(appExceptionCodeMsg.getCode(), appExceptionCodeMsg.getMsg(), null);
        return resp;
    }

    public static <T> Resp error(int code,String msg){
        Resp resp = new Resp(code,msg, null);
        return resp;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}