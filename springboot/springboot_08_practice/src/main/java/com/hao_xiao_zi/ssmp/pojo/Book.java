package com.hao_xiao_zi.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 20:36
 */
@Data
@TableName("book")
public class Book {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String description;
}
