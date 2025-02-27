package com.hao_xiao_zi.mybatis.mapper;

import com.hao_xiao_zi.mybatis.pojo.Car;

import java.util.List;

/**
* Created with IntelliJ IDEA.
* Description:
* User: 34255
* Date: 2025-02-27
* Time: 20:01
*/
public interface CarMapping {

    /**
     * 插入汽车信息
     * @param car 插入汽车西信息
     * @return 影响记录条数
     */
    int insertCar(Car car);

    /**
     * 根据ID删除汽车
     * @param id 汽车ID
     * @return 影响记录条数
     */
    int deleteCarById(Long id);

    /**
     * 更新指定汽车信息
     * @param car 更新后的汽车信息
     * @return 影响记录条数
     */
    int updateCarById(Car car);

    /**
     * 根据ID查询指定汽车
     * @param id 汽车ID
     * @return 查询到的汽车信息
     */
    Car selectOneById(Long id);

    /**
     * 所有汽车信息
     * @return 所有汽车信息
     */
    List<Car> selectAll();
}
