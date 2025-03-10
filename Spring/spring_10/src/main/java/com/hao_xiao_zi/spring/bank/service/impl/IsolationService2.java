package com.hao_xiao_zi.spring.bank.service.impl;

import com.hao_xiao_zi.spring.bank.dao.AccountDao;
import com.hao_xiao_zi.spring.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 16:31
 */
@Service
public class IsolationService2 {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    //进行插入账户信息操作
    //@Transactional(isolation = Isolation.READ_COMMITTED)//设置事务隔离级别
    //@Transactional(timeout = 10)//设置事务超时时长为10s,即执行到最后一条dml语句所花费的时间
    //大于超时时间，则之前所有的dml语句会进行回滚
    @Transactional(noRollbackFor = NullPointerException.class)//发生异常时，只有RuntimeException异常及子类异常事务才会进行回滚
    public void insertAccountInfo(Account act) throws IOException {
        //放在最后一条dml语句之前的所有代码的执行时间计入超时时间
        int count = accountDao.insertAccount(act);

//        String str = null;
//        str.toString();

//        throw new IOException();

//        if(1 == 1){
//            throw new RuntimeException();
//        }

        //睡眠，避免事务提前提交
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //放在最后一条dml语句后面的代码的执行时间不计入超时时间
    }
}
