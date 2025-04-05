package com.hao_xiao_zi.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-05
 * Time: 19:48
 */
//使用webEnvironment属性值为当前的测试类模拟开始web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//开启MVC虚拟调用,过程会创建MockMvc实例对象
@AutoConfigureMockMvc
public class WebEnvironmentTest {

    //自动注入虚拟请求的执行对象
    @Autowired
    private MockMvc mvc;

    @Test
    public void testWebEnvironment() throws Exception {
        //创建虚拟请求http:127.0.0.1:8080/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行虚拟请求
        mvc.perform(builder);
    }

    @Test
    public void testStatus() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/bookss");
        ResultActions perform = mvc.perform(builder);

        //获取状态结果匹配器
        StatusResultMatchers status = MockMvcResultMatchers.status();

        //设定预期值
        ResultMatcher ok = status.isOk();

        //预期值和实际值比较
        perform.andExpect(ok);
    }

    @Test
    public void testBody() throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行虚拟请求,获取本次执行结果对象
        ResultActions perform = mvc.perform(builder);

        //获取响应体结果匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();

        //设定预期值
        ResultMatcher springBoot = content.string("spring boot");

        //比较
        perform.andExpect(springBoot);
    }

    @Test
    public void testJson() throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        //执行虚拟请求,获取本次执行结果对象
        ResultActions perform = mvc.perform(builder);

        //获取响应体结果匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();

        //设定预期值
        ResultMatcher springBoot = content.json("{\"username\":\"zhansan\",\"password\":\"1234567\",\"age\":20}");

        //比较
        perform.andExpect(springBoot);
    }
}
