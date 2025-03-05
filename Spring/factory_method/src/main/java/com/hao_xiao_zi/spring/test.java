package com.hao_xiao_zi.spring;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 16:58
 */
public class test {
    public static void main(String[] args) {
        Factory gunFactory = new GunFactory();
        Weapon gun = gunFactory.get();
        gun.attack();

        Factory tankFactory = new TankFactory();
        Weapon tank = tankFactory.get();
        tank.attack();
    }
}
