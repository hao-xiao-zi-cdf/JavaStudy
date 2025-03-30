package com.hao_xiao_zi.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hao_xiao_zi.mybatisplus.enums.SexEnum;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-30
 * Time: 13:17
 */
@Data
@TableName("t_user")
public class User {

    @TableId("uid")
    private Long uid;

    private String userName;
    private Integer age;
    private String email;
    private SexEnum sex;

    @TableLogic
    private Integer isDelete;
}
