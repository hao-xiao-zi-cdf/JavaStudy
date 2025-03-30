package com.hao_xiao_zi.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-30
 * Time: 11:23
 */
@Getter
public enum SexEnum {

    MAN(1,"男"),
    WOMAN(2,"女");

    @EnumValue//该注解可将标注的属性的值存储到数据库中
    private Integer sexId;
    private String sexName;

    SexEnum(Integer sexId, String sexName) {
        this.sexId = sexId;
        this.sexName = sexName;
    }

}
