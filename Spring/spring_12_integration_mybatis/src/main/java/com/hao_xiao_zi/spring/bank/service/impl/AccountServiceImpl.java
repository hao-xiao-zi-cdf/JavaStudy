package com.hao_xiao_zi.spring.bank.service.impl;

import com.hao_xiao_zi.spring.bank.mapper.AccountMapper;
import com.hao_xiao_zi.spring.bank.pojo.Account;
import com.hao_xiao_zi.spring.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 21:09
 */
@Service("accountServiceImpl")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired//自动注入
    private AccountMapper accountMapper;

    @Override
    public int save(Account act) {
        int count = accountMapper.insert(act);
        return count;
    }

    @Override
    public int removeByActNo(String actno) {
        int count = accountMapper.deleteByActno(actno);
        return count;
    }

    @Override
    public int modify(Account act) {
        int update = accountMapper.update(act);
        return update;
    }

    @Override
    public Account queryOneByActNo(String actno) {
        Account account = accountMapper.selectByActno(actno);
        return account;
    }

    @Override
    public List<Account> queryAll() {
        List<Account> accounts = accountMapper.selectAll();
        return accounts;
    }

    @Override
    public void transfer(String fromAct, String toAct, Double money) {
        //1.判断转账方金额是否充足
        Account from = accountMapper.selectByActno(fromAct);
        if(from.getBalance() < money){
            //2.金额不足，抛出异常
            throw new RuntimeException("余额不足！");
        }

        Account to = accountMapper.selectByActno(toAct);
        //3.修改内存余额
        from.setBalance(from.getBalance() - money);
        to.setBalance(to.getBalance() + money);

        //4.进行转账操作
        int count = accountMapper.update(from);
        count += accountMapper.update(to);

        if(count != 2){
            System.out.println("转账失败，请联系银行");
        }
    }
}
