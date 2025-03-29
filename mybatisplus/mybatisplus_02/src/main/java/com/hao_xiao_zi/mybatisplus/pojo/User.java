package com.hao_xiao_zi.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-28
 * Time: 10:55
 */
@Data
//指定该实体类关联数据库中的哪一张表
//@TableName("t_user")
public class User {
//    mybatis-plus会分析实体类，并将属性抽取出来，将属性作为字段进行操作
//    @TableId(value = "uid",type = IdType.AUTO)
//    这个value属性的作用是指定id属性关联表中的主键字段
//    type属性用来设置主键id的生成策略:默认使用雪花算法，与数据库主键是否递增无关
//    使用主键自动自增策略前提：数据库主键必须设置为自增，且需要将type = IdType.AUTO
    @TableId("uid")
    private Long id;

    @TableField("user_name")
//    该注解作用是指定属性所关联的字段名称
    private String name;
    private Integer age;
    private String email;

    @TableLogic
    private Integer isDelete;
}
