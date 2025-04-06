package com.hao_xiao_zi.frontend.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-06
 * Time: 17:31
 */
@Data
public class User {

    private String username;
    private String password;
    private Integer id;

    //指定日期格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String sex;
    private String[] fav;
}
