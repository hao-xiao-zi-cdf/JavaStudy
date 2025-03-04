package com.hao_xiao_zi.spring.dao;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 19:32
 */
public class Stu {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                '}';
    }
}
