package com.hao_xiao_zi.spring.bank.dao.impl;

import com.hao_xiao_zi.spring.bank.dao.AccountDao;
import com.hao_xiao_zi.spring.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 8:46
 */
@Repository("accountDaoImpl")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int modifyAccountByActNo(Account account) {
        String sql = "update t_act set balance = ? where actno = ?";
        int count = jdbcTemplate.update(sql,account.getBalance(),account.getActno());
        return count;
    }

    @Override
    public Account selectAccountByActNo(String actno) {
        String sql = "select * from t_act where actno = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return account;
    }

    @Override
    public int insertAccount(Account act) {
        String sql = "INSERT INTO t_act (id, actno, balance) VALUES (null, ?, ?)";
        int count = jdbcTemplate.update(sql, act.getActno(), act.getBalance());
        return count;
    }
}
