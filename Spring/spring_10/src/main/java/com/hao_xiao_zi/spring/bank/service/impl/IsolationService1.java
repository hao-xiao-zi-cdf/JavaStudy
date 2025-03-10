package com.hao_xiao_zi.spring.bank.service.impl;

import com.hao_xiao_zi.spring.bank.dao.AccountDao;
import com.hao_xiao_zi.spring.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 16:30
 */
@Service
public class IsolationService1 {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    //进行查询数据库操作
    @Transactional(isolation = Isolation.READ_COMMITTED)//设置事务隔离级别
    public void selectAccountInfo(){
        Account account = accountDao.selectAccountByActNo("act003");
        System.out.println(account);
    }
}
