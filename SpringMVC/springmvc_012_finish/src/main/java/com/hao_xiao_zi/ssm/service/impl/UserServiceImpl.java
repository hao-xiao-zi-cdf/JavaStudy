package com.hao_xiao_zi.ssm.service.impl;

import com.hao_xiao_zi.ssm.bean.User;
import com.hao_xiao_zi.ssm.dao.UserDao;
import com.hao_xiao_zi.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-24
 * Time: 17:07
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(Integer id){
        User user = userDao.selectById(id);
        return user;
    }
}
