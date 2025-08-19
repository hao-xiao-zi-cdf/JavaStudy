package com.hao_xiao_zi.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hao_xiao_zi.bean.common.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-19
 * Time: 14:53
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 自定义实现限流异常处理
     * @param httpServletRequest 请求
     * @param httpServletResponse 响应
     * @param s 资源名
     * @param e 限流异常
     * @throws Exception 抛出异常
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse, String s, BlockException e) throws Exception {

        // 设置字符编码Json/UTF-8
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        R r = R.error("请求被限流或降级了：" + BlockException.BLOCK_EXCEPTION_MSG_PREFIX + ": " + e.getMessage());
        // 转化为Json字符串
        String json = objectMapper.writeValueAsString(r);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
