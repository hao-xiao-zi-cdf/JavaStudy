package com.hao_xiao_zi.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-19
 * Time: 11:09
 */
@Component
@Slf4j
public class OrderRequestInterceptor implements RequestInterceptor {

    /**
     * 添加x-token请求头信息
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("添加x-token请求头信息");
        requestTemplate.header("x-token", UUID.randomUUID().toString());
    }
}
