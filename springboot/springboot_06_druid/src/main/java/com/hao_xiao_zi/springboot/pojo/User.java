package com.hao_xiao_zi.springboot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-31
 * Time: 19:29
 */
@TableName("t_user")
@Data
public class User {
    private Long id;
    private String userName;
    private Integer age;
    private String email;
}
