package com.hao_xiao_zi.spring.bank.service.impl;

import com.hao_xiao_zi.spring.bank.dao.AccountDao;
import com.hao_xiao_zi.spring.bank.pojo.Account;
import com.hao_xiao_zi.spring.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 15:14
 */
@Service("accountServiceImpl2")
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public void Transfer(String fromAct, String toAct, Double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account act) {
        //插入account2用户信息
        int count = accountDao.insertAccount(act);
        String str = null;
        str.toString();

    }
}
