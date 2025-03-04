package com.hao_xiao_zi.spring.service;

import com.hao_xiao_zi.spring.dao.UserImpl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 15:29
 */
public class UserServiceImpl {

    private UserImpl userDao;

    public void setUserDao(UserImpl userDao) {
        this.userDao = userDao;
    }

    public void deleteUserService(){
        userDao.deleteById();
    }
}
