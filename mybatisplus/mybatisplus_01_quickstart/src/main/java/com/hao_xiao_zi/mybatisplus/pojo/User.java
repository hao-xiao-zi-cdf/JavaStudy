package com.hao_xiao_zi.mybatisplus.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-27
 * Time: 20:37
 */
@Data
@Component
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
