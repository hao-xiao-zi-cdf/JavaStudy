package com.hao_xiao_zi.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-19
 * Time: 21:20
 */
@Slf4j
@Component
public class RtGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 前置过滤
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        URI uri = request.getURI();

        // 获取当前时间
        long start = System.currentTimeMillis();
        log.info("访问路径：{}，开始时间：{}", uri,start);

        //========================================
        Mono<Void> filter = chain.filter(exchange).
                doFinally((result) -> {
                    long end = System.currentTimeMillis();
                    log.info("总共耗时：{}", end - start);
                });
        return filter;
    }
}
