package com.hmdp.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result sendCode(String phone, HttpSession session) {

        //1. 检验手机号码,使用正则表达式工具类检验
        if(RegexUtils.isPhoneInvalid(phone)){
            //2. 手机号码不符合规范，返回错误消息
            return Result.fail("手机号码填写错误，请重新填写");
        }
        //3. 生成验证码,使用hutool-all工具包中的RandomUtil类生成验证码
        String code = RandomUtil.randomNumbers(6);

        //4. 存储验证码到session中
        session.setAttribute("code",code);

        //打印日志
        log.debug("生成验证码：" + code);

        //5. 返回验证码
        return Result.ok();
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        //1. 检验手机号码格式
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            //2. 格式错误，返回错误信息
            return Result.fail("手机号码错误，请重新登录");
        }
        //3. 检验验证码
        Object cacheCode = session.getAttribute("code");
        String code = loginForm.getCode();
        if(code == null || !cacheCode.toString().equals(code)){
            //4. 验证码错误或过期，返回错误信息
            return Result.fail("验证码错误，请重新登录");
        }
        //5. 判断用户是进行登录还是注册，根据用户手机号查询数据库
        User user = query().eq("phone", phone).one();


        //6. 判断用户是否存在
        if(user == null){
            //7. 不存在，创建新用户保存到数据库
            user = new User();
            user.setPhone(phone);
            user.setNickName("USER_NICK_NAME_PREFIX" + RandomUtil.randomString(10));
            save(user);
        }

        //8. 将用户信息存储到session中
        session.setAttribute("user",user);
        log.debug("用户信息：" + user);
        return Result.ok();
    }
}
