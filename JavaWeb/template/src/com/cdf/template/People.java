package com.cdf.template;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-22
 * Time: 22:10
 */
public abstract class People {

    public void day(){
        getUp();
        brushTeeth();
        haveBreakfast();
        work();
        haveDinner();
        sleep();
    }

    public void getUp(){
        System.out.println("起床");
    }

    public void brushTeeth(){
        System.out.println("刷牙");
    }

    public void haveBreakfast(){
        System.out.println("吃早餐");
    }

    public abstract void work();

    public void haveDinner(){
        System.out.println("吃晚饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }
}
