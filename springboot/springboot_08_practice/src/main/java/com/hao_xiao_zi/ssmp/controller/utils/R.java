package com.hao_xiao_zi.ssmp.controller.utils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 21:20
 */

import lombok.Data;

/**
 * 该类为后端Controller层方法返回给前端的模型类，用来统一控制层方法返回前端的数据格式，减少前端读取后端返回数据的开发难度
 */
@Data
public class R {
    private boolean flag;
    private Object data;

    public R(boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(boolean flag){
        this.flag = flag;
    }
}
