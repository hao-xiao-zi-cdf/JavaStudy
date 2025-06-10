package com.hao_xiao_zi.globalexceptionhandlerdemo.exception;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-06-10
 * Time: 21:51
 */
public class AppException extends RuntimeException{

  private int code = 500;
  private String msg = "服务器异常";


  public AppException(AppExceptionCodeMsg appExceptionCodeMsg){
    super();
    this.code = appExceptionCodeMsg.getCode();
    this.msg = appExceptionCodeMsg.getMsg();
  }

  public AppException(int code,String msg){
    super();
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

}
