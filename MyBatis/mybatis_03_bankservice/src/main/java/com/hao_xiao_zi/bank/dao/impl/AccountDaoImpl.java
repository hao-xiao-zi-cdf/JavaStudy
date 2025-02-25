package com.hao_xiao_zi.bank.dao.impl;

import com.hao_xiao_zi.bank.dao.AccountDao;
import com.hao_xiao_zi.bank.pojo.Account;
import com.hao_xiao_zi.bank.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-25
 * Time: 17:14
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectBalance(String fromTransfer) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Account account = sqlSession.selectOne("Account.selectAccount",fromTransfer);
        return account;
    }

    @Override
    public int updateBalance(Account account) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        int count = sqlSession.update("Account.updateAccount",account);
        return count;
    }
}
