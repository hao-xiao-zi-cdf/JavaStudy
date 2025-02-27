package com.hao_xiao_zi.mybatis.mapper;

import com.hao_xiao_zi.mybatis.pojo.Car;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-27
 * Time: 20:38
 */
public interface CarMapping {
    /**
     * 根据汽车种类查询车辆
     * @return 相关联汽车
     */
    List<Car> selectCarByCarType(String car_type);

    /**
     * 根据汽车的价格进行升序降序排序
     * @param descOrAsc
     * @return
     */
    List<Car> selectCarByDescOrAsc(String descOrAsc);

    /**
     * 模糊查询相关车辆
     * @param dim 模糊匹配名称
     * @return 相关车辆
     */
    List<Car> selectCarByDim(String dim);
}
