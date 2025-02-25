package com.hao_xiao_zi.bank.service.impl;

import com.hao_xiao_zi.bank.dao.impl.AccountDaoImpl;
import com.hao_xiao_zi.bank.execption.MoneyNotEnoughException;
import com.hao_xiao_zi.bank.execption.TransferException;
import com.hao_xiao_zi.bank.pojo.Account;
import com.hao_xiao_zi.bank.service.AccountService;
import com.hao_xiao_zi.bank.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-25
 * Time: 17:03
 */
public class AccountServiceImpl implements AccountService {

    //可能其他的业务方法也需要使用
    private static AccountDaoImpl accountDao = new AccountDaoImpl();
    @Override
    public void AccountTransfer(String fromTransfer,String toTransfer,Double money) throws MoneyNotEnoughException, TransferException {
        //1.查询转账方账户余额(select)
        Account fromAct = accountDao.selectBalance(fromTransfer);
        if(fromAct.getBalance() < money){
            //2.余额不足抛出异常
            throw new MoneyNotEnoughException();
        }
        //3.余额充足，扣除转账方余额(update)
        Account toAct = accountDao.selectBalance(toTransfer);
        //更新内存余额
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        int count = accountDao.updateBalance(fromAct);
        //4.修改收款方余额(update)

        //模拟发生异常
//        String str = null;
//        str.toLowerCase();

        count += accountDao.updateBalance(toAct);
        if(count != 2){
            //抛异常
            throw new TransferException();
        }

        sqlSession.commit();
        SqlSessionUtils.close(sqlSession);
    }
}
