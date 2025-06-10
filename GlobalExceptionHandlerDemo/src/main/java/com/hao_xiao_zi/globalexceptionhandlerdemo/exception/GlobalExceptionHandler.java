package com.hao_xiao_zi.globalexceptionhandlerdemo.exception;

import com.hao_xiao_zi.globalexceptionhandlerdemo.pojo.Resp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-06-10
 * Time: 21:50
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    //设置可以捕获的异常类型
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public <T> Resp<T> exceptionHandler(Exception e){//捕获到的异常会赋值给方法形参
        //这里先判断拦截到的Exception是不是我们自定义的异常类型
        if(e instanceof AppException){
            AppException appException = (AppException)e;
            return Resp.error(appException.getCode(),appException.getMsg());
        }

        //如果拦截的异常不是我们自定义的异常(例如：数据库主键冲突)
        return Resp.error(500,"服务器端异常");
    }
}
