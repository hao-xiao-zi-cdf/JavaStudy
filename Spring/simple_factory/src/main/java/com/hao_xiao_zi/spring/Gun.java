package com.hao_xiao_zi.spring;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 16:39
 */
public class Gun extends Weapon{
    @Override
    void attack() {
        System.out.println("开枪...");
    }
}
