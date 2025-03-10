package com.hao_xiao_zi.spring.bank.service;

import com.hao_xiao_zi.spring.bank.pojo.Account;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 21:02
 */
public interface AccountService {
    /**
     * 新增账户信息
     * @param act 账户信息
     * @return 影响条数
     */
    int save(Account act);

    /**
     * 根据账号移除账户
     * @param actno 账号
     * @return 影响条数
     */
    int removeByActNo(String actno);

    /**
     * 更新账户信息
     * @param act 账户信息
     * @return 影响条数
     */
    int modify(Account act);

    /**
     * 根据账号查询账户信息
     * @param actno 账号
     * @return 账户信息
     */
    Account queryOneByActNo(String actno);

    /**
     * 查询所有账户信息
     * @return 所有账户信息
     */
    List<Account> queryAll();

    /**
     * 转账业务
     * @param fromAct 转账方
     * @param toAct 收款方
     * @param money 转账金额
     */
    void transfer(String fromAct,String toAct,Double money);
}
