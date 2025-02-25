package com.hao_xiao_zi.bank.service;

import com.hao_xiao_zi.bank.execption.MoneyNotEnoughException;
import com.hao_xiao_zi.bank.execption.TransferException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-25
 * Time: 17:01
 */
public interface AccountService {

    void AccountTransfer(String fromTransfer,String toTransfer,Double money) throws MoneyNotEnoughException, TransferException;
}
