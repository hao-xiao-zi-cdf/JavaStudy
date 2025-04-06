package com.hao_xiao_zi.ssmp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-06
 * Time: 10:05
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//springBoot发现为测试类且有@Transactional注解，会对测试类提交的事务进行回滚
@Transactional
//手动关闭事务回滚
@Rollback(value = false)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testSave() throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/books");
        //执行虚拟请求
        mvc.perform(builder);
    }
}
