package com.hao_xiao_zi.ssm.service;

import com.hao_xiao_zi.ssm.bean.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-24
 * Time: 18:19
 */
public interface UserService {

    User selectUserById(Integer id);
}
