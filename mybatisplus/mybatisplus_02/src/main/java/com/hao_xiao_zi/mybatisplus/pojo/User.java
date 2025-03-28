package com.hao_xiao_zi.mybatisplus.pojo;

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
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
