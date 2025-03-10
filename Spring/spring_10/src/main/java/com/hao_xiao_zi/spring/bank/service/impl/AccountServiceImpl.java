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
 * Time: 9:04
 */
@Service("accountServiceImpl")
//@Transactional//在类上使用表示该类中的所有方法默认由spring进行事务管理
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
//    @Transactional
    public void Transfer(String fromAct, String toAct, Double money) {
        //1.先判断余额是否充足
        Account fromAccount = accountDao.selectAccountByActNo(fromAct);
        if(fromAccount.getBalance() < money){
            //2.不充足抛出异常
            throw new RuntimeException("余额不足，请充值！");
        }

        Account toAccount = accountDao.selectAccountByActNo(toAct);

        //3.修改内存余额
        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);

        //4.执行修改语句
        int count = accountDao.modifyAccountByActNo(fromAccount);

        //模拟中间发生空指针异常
//        String str = null;
//        str.toString();

        count += accountDao.modifyAccountByActNo(toAccount);

        if(count != 2){
            throw new RuntimeException("转账失败，请联系银行！");
        }
    }

    //注入accountServiceImpl2对象
    @Resource(name = "accountServiceImpl2")
    private AccountService accountService;

    @Override
//    设置事务传播行为
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act){
        //插入account1用户信息
        accountDao.insertAccount(act);

        //创建Account用户
        Account act2 = new Account(null,"act004",1000.0);
        //调用AccountServiceImpl2对象的save方法
        try{
            accountService.save(act2);
        } catch (Exception e){
            e.printStackTrace();
        }
        //因为这里处理了抛出来的异常，所以还能继续往下执行结束，事务正常提交

//        accountService.save(act2);
        //这里两个事务都会进行回滚，因为这里没有处理抛出来的异常，不能继续往下执行
    }
}
