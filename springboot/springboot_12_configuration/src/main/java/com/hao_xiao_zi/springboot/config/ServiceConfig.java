package com.hao_xiao_zi.springboot.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-03
 * Time: 21:10
 */
@Data
//@Component
@ConfigurationProperties(prefix = "service.config")
//为当前的bean对象开启数据校验功能
@Validated
public class ServiceConfig {
    private String ipAddress;
    private Integer port;

    //设置具体规则
    @Max(value = 8888L,message = "数据超过最大值")
    @Min(value = 0,message = "数据超过最小值")
    private long timeOut;

    //JDK8后提供了一个新的类，用来表示时间范围
    @DurationUnit(ChronoUnit.DAYS)//自定义单位种类
    private Duration serviceTimeOut;

    //JDK8提供的一个单位，用来表示数据大小范围
//    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
