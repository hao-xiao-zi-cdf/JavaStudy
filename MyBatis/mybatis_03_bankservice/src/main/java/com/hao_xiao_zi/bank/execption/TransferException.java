package com.hao_xiao_zi.bank.execption;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-25
 * Time: 19:27
 */
public class TransferException extends Exception{
    public TransferException(){

    }

    public TransferException(String massage){
        super(massage);
    }
}
