package com.hao_xiao_zi.bank.dao;

import com.hao_xiao_zi.bank.pojo.Account;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-25
 * Time: 17:08
 */
public interface AccountDao {
    //根据账户查询余额，并返回对象
    Account selectBalance(String fromTransfer);

    //更新账户余额
    int updateBalance(Account account);
}
