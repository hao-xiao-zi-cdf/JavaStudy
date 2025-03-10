package com.hao_xiao_zi.spring.bank;

import com.hao_xiao_zi.spring.bank.pojo.Account;
import com.hao_xiao_zi.spring.bank.service.AccountService;
import com.hao_xiao_zi.spring.bank.service.impl.IsolationService1;
import com.hao_xiao_zi.spring.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 9:14
 */
public class TransferServiceTest {

    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountServiceImpl = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try{
            accountServiceImpl.Transfer("act001","act002",1000.0);
            //转账成功
            System.out.println("转账成功！");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 isolationService2 = applicationContext.getBean("isolationService2", IsolationService2.class);
        //创建Account用户
        Account act = new Account(null,"act003",1000.0);
        isolationService2.insertAccountInfo(act);
    }


    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 isolationService1 = applicationContext.getBean("isolationService1", IsolationService1.class);
        isolationService1.selectAccountInfo();
    }

    @Test
    public void testSave(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountServiceImpl = applicationContext.getBean("accountServiceImpl", AccountService.class);
        //创建Account用户
        Account act = new Account(null,"act003",1000.0);
        accountServiceImpl.save(act);
    }

    @Test
    public void testTransferService(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountServiceImpl = applicationContext.getBean("accountServiceImpl", AccountService.class);
        try{
            accountServiceImpl.Transfer("act001","act002",1000.0);
            //转账成功
            System.out.println("转账成功！");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
