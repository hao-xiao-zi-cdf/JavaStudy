package com.hao_xiao_zi.ssmp.controller.utils;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 16:24
 */
@Data
public class R {
    private boolean flag;
    private Object data;

    public R(boolean flag){
        this.flag = flag;
    }

    public R(boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
}
