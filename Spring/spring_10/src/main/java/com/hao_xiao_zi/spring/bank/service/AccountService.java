package com.hao_xiao_zi.spring.bank.service;

import com.hao_xiao_zi.spring.bank.pojo.Account;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 9:02
 */
public interface AccountService {

    void Transfer(String fromAct,String toAct,Double money);

    void save(Account act);
}
