package com.hao_xiao_zi.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-24
 * Time: 17:00
 */
@Configuration
@ComponentScan({"com.hao_xiao_zi.ssm.service"})
@PropertySource("classpath:jdbc.properties")
@Import({DataSourceConfig.class, MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {

}
