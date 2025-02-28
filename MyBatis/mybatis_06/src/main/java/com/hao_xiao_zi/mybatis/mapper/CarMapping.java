package com.hao_xiao_zi.mybatis.mapper;


import com.hao_xiao_zi.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-27
 * Time: 20:38
 */
public interface CarMapping {

    /**
     * 插入汽车数据的同时获取自增主键值
     * @param car 插入的汽车信息
     * @return 影响条数
     */
    int insertCarAndGetId(Car car);

    /**
     * 查询car表中的总记录条数
     * @return 总记录条数
     */
    Integer selectCarCount();

    /**
     * 使用resultMap告诉mybatis对象的属性对应表中哪个字段
     * @return 返回所有汽车信息
     */
    List<Car> selectAllCarByResultMap();

    /**
     * @return 以大Map的形式返回所有的汽车信息,key值为汽车主键值id,value为该Id汽车的信息以map形式存储
     */
//    @MapKey("id")表示将获取到的汽车信息中的id作为大map的key值
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllCarByRetMap();
}
