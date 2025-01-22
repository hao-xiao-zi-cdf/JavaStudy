package com.cdf.template;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-22
 * Time: 22:14
 */
public class Test {
    public static void main(String[] args) {
        People people1 = new Student();
        people1.day();

        People people2 = new Teacher();
        people2.day();
    }
}
