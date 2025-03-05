package com.hao_xiao_zi.spring;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 16:41
 */
public class WeaponFactory {

    //获取武器
    public Weapon get(String weaponName){
        if(weaponName.equalsIgnoreCase("gun")){
            return new Gun();
        }else if(weaponName.equalsIgnoreCase("tank")){
            return new Tank();
        } else{
            throw new RuntimeException("没有该武器");
        }
    }
}
