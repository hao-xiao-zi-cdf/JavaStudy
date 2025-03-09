package com.hao_xiao_zi.spring.biz;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 19:08
 */
@Service
public class VipService {
    //目标方法
    public void addVipInfo(){
        System.out.println("新增会员信息");
    }

    //目标方法
    public void delVipInfo(){
        System.out.println("删除会员信息");
    }

    //目标方法
    public void selectVipInfo(){
        System.out.println("查询会员信息");
    }

    //目标方法
    public void modifyVipInfo(){
        System.out.println("修改会员信息");
    }
}
