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
 * Date: 2025-03-23
 * Time: 17:21
 */
@Configuration//标记该类为配置类，代替web.xml
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //配置spring
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //配置springmvc
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    //配置DispatcherServlet映射的请求路径即<url-pattern></url-pattern>
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

    //配置过滤器
    @Override
    protected Filter[] getServletFilters() {
        //创建字符编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceRequestEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
        //创建隐含的http方法过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
