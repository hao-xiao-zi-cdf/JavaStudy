package com.hao_xiao_zi.spring.Bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 19:40
 */
public class Dog {
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "birth=" + birth +
                '}';
    }
}
