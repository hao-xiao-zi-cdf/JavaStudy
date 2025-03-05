package com.hao_xiao_zi.spring;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 16:44
 */
public class Test {

    //客户端
    public static void main(String[] args) {
        WeaponFactory factory = new WeaponFactory();

        Weapon gun = factory.get("Gun");
        gun.attack();

        Weapon tank = factory.get("Tank");
        tank.attack();
    }
}
