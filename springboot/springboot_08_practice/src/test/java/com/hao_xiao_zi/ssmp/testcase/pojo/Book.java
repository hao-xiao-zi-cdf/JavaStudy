package com.hao_xiao_zi.ssmp.testcase.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-06
 * Time: 10:48
 */
@Data
@TableName("book")
@Component
@ConfigurationProperties(prefix = "testcase.book")
public class Book {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String description;
}