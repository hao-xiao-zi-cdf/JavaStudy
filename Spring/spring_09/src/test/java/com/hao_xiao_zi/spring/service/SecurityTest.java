package com.hao_xiao_zi.spring.service;

import com.hao_xiao_zi.spring.biz.UserService;
import com.hao_xiao_zi.spring.biz.VipService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 19:26
 */
public class SecurityTest {
    @Test
    public void testSecurity(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);

        vipService.addVipInfo();
        vipService.delVipInfo();
        vipService.modifyVipInfo();
        vipService.selectVipInfo();

        userService.addUserInfo();
        userService.delUserInfo();
        userService.modifyUserInfo();
        userService.selectUserInfo();
    }
}
