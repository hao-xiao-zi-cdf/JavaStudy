package com.hao_xiao_zi.spring.Bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 19:49
 */
public class DateFactory implements FactoryBean<Date> {

    private String date;

    //使用构造方法注入
    public DateFactory(String date){
        this.date = date;
    }

    @Override
    public Date getObject() throws Exception {
        //格式化日期格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //将字符串转化为该格式的Date对象
        return format.parse(date);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
