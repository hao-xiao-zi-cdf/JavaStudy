package com.hao_xiao_zi.spring;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 17:04
 */
public class GunFactory extends Factory{
    @Override
    Weapon get() {
        return new Gun();
    }
}
