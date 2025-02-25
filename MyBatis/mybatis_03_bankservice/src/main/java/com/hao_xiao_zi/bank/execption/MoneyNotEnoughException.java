package com.hao_xiao_zi.bank.execption;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-25
 * Time: 19:20
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){

    }
    public MoneyNotEnoughException(String message){
        super(message);
    }
}
