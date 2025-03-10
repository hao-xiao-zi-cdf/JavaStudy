package com.hao_xiao_zi.spring.bank.dao;

import com.hao_xiao_zi.spring.bank.pojo.Account;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 8:46
 */
public interface AccountDao {

    /**
     * 根据账户信息修改数据
     * @param account 账户
     * @return 更改条数
     */
    int modifyAccountByActNo(Account account);

    /**
     * 根据账号查询信息
     * @param actno 账号
     * @return 信息
     */
    Account selectAccountByActNo(String actno);

    /**
     * 插入新用户信息
     * @param act 用户信息
     * @return 影响记录条数
     */
    int insertAccount(Account act);
}
