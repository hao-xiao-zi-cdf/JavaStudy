package com.hao_xiao_zi.mybatis.mapper;


import com.hao_xiao_zi.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

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
     * 根据前端页面用户的行为后端对应动态生成对应的sql语句进行条件查询
     * @param brand 模糊查询 汽车品牌
     * @param price 条件查询 价格
     * @param carType 条件查询 汽车种类
     * @return 动态返回符合条件的汽车信息
     */
    List<Car> selectCarByDynamicCondition(@Param("brand") String brand, @Param("price")Double price, @Param("carType")String carType);
}
