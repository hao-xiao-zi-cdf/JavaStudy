package com.hao_xiao_zi.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-30
 * Time: 10:46
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version//设置乐观锁版本号
    private Integer version;
}