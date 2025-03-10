package com.hao_xiao_zi.spring.bank;

import com.hao_xiao_zi.spring.bank.service.AccountService;
import com.hao_xiao_zi.spring.bank.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 21:41
 */
public class AccountServiceTest {

    @Test
    public void testSM(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountServiceImpl accountService = applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);
        try{
            accountService.transfer("act001","act002",1000.0);
            System.out.println("转账成功");
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
