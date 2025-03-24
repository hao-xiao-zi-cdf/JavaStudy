package com.hao_xiao_zi.springmvc.config;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-24
 * Time: 15:15
 */
//该注解标记该类为配置类，代替web.xml
@Configuration
public class WebAppInitialization extends AbstractAnnotationConfigDispatcherServletInitializer {

    //配置spring
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //配置springmvc
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    //配置DispatcherServlet的<url-pattern></url-pattern>,可以配置多个
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //配置过滤器
    @Override
    protected Filter[] getServletFilters() {
        //配置字符编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8",true,true);
        //配置隐含的http请求方式过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        //添加过滤器
        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
