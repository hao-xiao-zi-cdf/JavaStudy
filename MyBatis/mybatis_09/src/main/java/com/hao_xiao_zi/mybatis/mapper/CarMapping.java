package com.hao_xiao_zi.mybatis.mapper;

import com.hao_xiao_zi.mybatis.pojo.Car;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-02
 * Time: 10:59
 */
public interface CarMapping {
    /**
     * 验证mybatis的一级缓存机制
     * @return
     */
    Car selectCarByCache(Long id);

    Car selectCarByCache1(Long id);
}
