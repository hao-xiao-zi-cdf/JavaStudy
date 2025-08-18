package com.hao_xiao_zi.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 16:33
 */
@Data
@Component
@ConfigurationProperties(prefix = "order")// 配置批量绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
public class OrderProperties {

    String timeout;

    String autoConfirm;
}
