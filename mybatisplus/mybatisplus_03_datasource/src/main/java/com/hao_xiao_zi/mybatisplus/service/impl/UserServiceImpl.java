package com.hao_xiao_zi.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import com.hao_xiao_zi.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-30
 * Time: 13:26
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
