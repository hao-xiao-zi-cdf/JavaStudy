package com.hao_xiao_zi.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 书籍类型
     */
    private String type;

    /**
     * 书名
     */
    private String name;

    /**
     * 描述
     */
    private String description;
}